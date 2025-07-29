package com.mayur.Slotify.Controller;

import com.mayur.Slotify.Dtos.AttendeeDto;
import com.mayur.Slotify.Service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendees")
public class AttendeeController {
    private final AttendeeService attendeeService;

    @Autowired
    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @PostMapping
    public ResponseEntity<AttendeeDto> createAttendee(@RequestBody AttendeeDto attendeeDto) {
        return new ResponseEntity<>(attendeeService.addAttendee(attendeeDto), HttpStatus.CREATED);
    }
}
