package com.mayur.Slotify.Service;

import com.mayur.Slotify.Configuration.ModelMapperConfig;
import com.mayur.Slotify.Dtos.AttendeeDto;
import com.mayur.Slotify.Model.Attendee;
import com.mayur.Slotify.Repository.AttendeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendeeService {
    private final AttendeeRepository attendeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AttendeeService(AttendeeRepository attendeeRepository, ModelMapper modelMapper) {
        this.attendeeRepository = attendeeRepository;
        this.modelMapper = modelMapper;
    }

    public AttendeeDto addAttendee(AttendeeDto attendeeDto){
        Attendee attendee = modelMapper.map(attendeeDto, Attendee.class);
        Attendee savedAttendee = attendeeRepository.save(attendee);
        return modelMapper.map(savedAttendee, AttendeeDto.class);
    }
}
