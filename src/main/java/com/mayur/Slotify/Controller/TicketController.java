package com.mayur.Slotify.Controller;

import com.mayur.Slotify.Dtos.TicketDto;
import com.mayur.Slotify.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<TicketDto> add(@RequestBody TicketDto ticketDto) {
        return new ResponseEntity<>(ticketService.createTicket(ticketDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TicketDto>> getAll() {
        return new ResponseEntity<>(ticketService.getAllTickets(), HttpStatus.OK);
    }

    @GetMapping("{ticketId}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable Long ticketId) {
        return new ResponseEntity<>(ticketService.getTicketById(ticketId), HttpStatus.OK);
    }

    @DeleteMapping("{ticketId}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long ticketId) {
        ticketService.deleteTicket(ticketId);
        return ResponseEntity.noContent().build();
    }
}
