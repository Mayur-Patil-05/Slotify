package com.mayur.Slotify.Service;

import com.mayur.Slotify.Dtos.TicketDto;
import com.mayur.Slotify.Model.Attendee;
import com.mayur.Slotify.Model.Event;
import com.mayur.Slotify.Model.Ticket;
import com.mayur.Slotify.Repository.AttendeeRepository;
import com.mayur.Slotify.Repository.EventRepository;
import com.mayur.Slotify.Repository.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;
    private final AttendeeRepository attendeeRepository;
    private final EventRepository eventRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, ModelMapper modelMapper, AttendeeRepository attendeeRepository, EventRepository eventRepository) {
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
        this.attendeeRepository = attendeeRepository;
        this.eventRepository = eventRepository;
    }

    public TicketDto createTicket(TicketDto ticketDto){
        Attendee attendee = attendeeRepository.findByEmail(ticketDto.getAttendeeEmail().getEmail());
        Event event = eventRepository.findByTitle(ticketDto.getEventTitle().getTitle());

        Ticket ticket = modelMapper.map(ticketDto, Ticket.class);
        ticket.setAttendee(attendee);
        ticket.setEvent(event);
        Ticket savedTicket = ticketRepository.save(ticket);
        return modelMapper.map(savedTicket, TicketDto.class);
    }
}
