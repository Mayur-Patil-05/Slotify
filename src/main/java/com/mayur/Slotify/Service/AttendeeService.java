package com.mayur.Slotify.Service;

import com.mayur.Slotify.Configuration.ModelMapperConfig;
import com.mayur.Slotify.Dtos.AttendeeDto;
import com.mayur.Slotify.Model.Attendee;
import com.mayur.Slotify.Repository.AttendeeRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeService {
    private final AttendeeRepository attendeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AttendeeService(AttendeeRepository attendeeRepository, ModelMapper modelMapper) {
        this.attendeeRepository = attendeeRepository;
        this.modelMapper = modelMapper;
    }

    public AttendeeDto addAttendee(AttendeeDto attendeeDto) {
        Attendee attendee = modelMapper.map(attendeeDto, Attendee.class);
        Attendee savedAttendee = attendeeRepository.save(attendee);
        return modelMapper.map(savedAttendee, AttendeeDto.class);
    }

    public List<AttendeeDto> getAllAttendees() {
        List<Attendee> attendees = attendeeRepository.findAll();
        return attendees.stream().map(attendee -> modelMapper.map(attendee, AttendeeDto.class)).toList();
    }

    public AttendeeDto getAttendeeByEmail(String email) {
        Attendee attendee = attendeeRepository.findByEmail(email);
        return modelMapper.map(attendee, AttendeeDto.class);
    }

    @Transactional
    public AttendeeDto updateAttendee(String email, AttendeeDto attendeeDto) {
        Attendee attendee = attendeeRepository.findByEmail(email);

        if (attendeeDto.getFirstName() != null) {
            attendee.setFirstName(attendeeDto.getFirstName());
        }
        if (attendeeDto.getLastName() != null) {
            attendee.setLastName(attendeeDto.getLastName());
        }
        if (attendeeDto.getPhone() != null) {
            attendee.setPhone(attendeeDto.getPhone());
        }

        return modelMapper.map(attendee, AttendeeDto.class);
    }

    public void deleteAttendeeByEmail(String email) {
        Attendee attendee = attendeeRepository.findByEmail(email);
        attendeeRepository.delete(attendee);
    }
}
