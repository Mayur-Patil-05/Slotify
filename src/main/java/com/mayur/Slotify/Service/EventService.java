package com.mayur.Slotify.Service;

import com.mayur.Slotify.Dtos.EventDto;
import com.mayur.Slotify.Dtos.VenueDto;
import com.mayur.Slotify.Enum.EventCategory;
import com.mayur.Slotify.Exception.EventNotFoundException;
import com.mayur.Slotify.Exception.VenueNotFoundException;
import com.mayur.Slotify.Model.Event;
import com.mayur.Slotify.Model.Venue;
import com.mayur.Slotify.Repository.EventRepository;
import com.mayur.Slotify.Repository.VenueRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EventService(EventRepository eventRepository, VenueRepository venueRepository, ModelMapper modelMapper) {
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public EventDto bookVenue(EventDto eventDto) throws VenueNotFoundException {
        if (eventDto.getVenue().getName() == null || eventDto.getVenue() == null) {
            throw new VenueNotFoundException("Venue name is missing.");
        }

        Venue venue = venueRepository.findByName(eventDto.getVenue().getName());
        if (venue == null) {
            throw new VenueNotFoundException("Venue not found with name: " + eventDto.getVenue().getName());
        }
        Event event = modelMapper.map(eventDto, Event.class);
        event.setVenue(venue);
        Event savedEvent = eventRepository.save(event);
        return modelMapper.map(savedEvent, EventDto.class);
    }

    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> modelMapper.map(event, EventDto.class)).toList();
    }

    public EventDto getEventById(Long eventId) throws EventNotFoundException {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event not found with id:" + eventId));
        return modelMapper.map(event, EventDto.class);
    }

    @Transactional
    public EventDto updateEvent(Long eventId, EventDto eventDto) throws EventNotFoundException {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event not found with id:" + eventId));

        if (eventDto.getTitle() != null) {
            event.setTitle(eventDto.getTitle());
        }
        if (eventDto.getDescription() != null) {
            event.setDescription(eventDto.getDescription());
        }
        if (eventDto.getLocation() != null) {
            event.setLocation(eventDto.getLocation());
        }
        if (eventDto.getStartTime() != null) {
            event.setStartTime(eventDto.getStartTime());
        }
        if (eventDto.getEndTime() != null) {
            event.setEndTime(eventDto.getEndTime());
        }
        if (eventDto.getOrganizer() != null) {
            event.setOrganizer(eventDto.getOrganizer());
        }
        if (eventDto.getCategory() != null) {
            event.setCategory(eventDto.getCategory());
        }
        return modelMapper.map(event, EventDto.class);
    }

    public void deleteEvent(Long eventId) throws EventNotFoundException {
        if (!eventRepository.existsById(eventId)) {
            throw new EventNotFoundException("Event not found with id:" + eventId);
        }
        eventRepository.deleteById(eventId);
    }
}
