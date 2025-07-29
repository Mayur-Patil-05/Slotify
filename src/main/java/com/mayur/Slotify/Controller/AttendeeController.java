package com.mayur.Slotify.Controller;

import com.mayur.Slotify.Dtos.AttendeeDto;
import com.mayur.Slotify.Service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<AttendeeDto>> getAllAttendees() {
        return new ResponseEntity<>(attendeeService.getAllAttendees(), HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<AttendeeDto> getAttendeeByEmail(@PathVariable String email) {
        return new ResponseEntity<>(attendeeService.getAttendeeByEmail(email), HttpStatus.OK);
    }

    @PutMapping("/{email}")
    public ResponseEntity<AttendeeDto> updateAttendee(@PathVariable String email, @RequestBody AttendeeDto attendeeDto) {
        return new ResponseEntity<>(attendeeService.updateAttendee(email, attendeeDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteAttendeeByEmail(@PathVariable String email) {
        attendeeService.deleteAttendeeByEmail(email);
        return ResponseEntity.noContent().build();
    }
}
