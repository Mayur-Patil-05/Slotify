package com.mayur.Slotify.Controller;

import com.mayur.Slotify.Dtos.VenueDto;
import com.mayur.Slotify.Service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venues")
public class VenueController {
    private final VenueService venueService;

    @Autowired
    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @PostMapping
    public ResponseEntity<VenueDto> addVenue(@RequestBody VenueDto venueDto) {
        return new ResponseEntity<>(venueService.addVenue(venueDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VenueDto>> getAllVenues() {
        return new ResponseEntity<>(venueService.getAllVenues(), HttpStatus.OK);
    }

    @GetMapping("/{venueId}")
    public ResponseEntity<VenueDto> getVenueById(@PathVariable Long venueId) {
        return new ResponseEntity<>(venueService.getVenueById(venueId), HttpStatus.OK);
    }

    @PutMapping("/{venueId}")
    public ResponseEntity<VenueDto> updateVenue(@PathVariable Long venueId, @RequestBody VenueDto venueDto) {
        return new ResponseEntity<>(venueService.updateVenue(venueId, venueDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{venueId}")
    public ResponseEntity<Void> deleteVenue(@PathVariable Long venueId) {
        venueService.deleteVenue(venueId);
        return ResponseEntity.noContent().build();
    }
}
