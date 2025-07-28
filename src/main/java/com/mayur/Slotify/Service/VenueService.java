package com.mayur.Slotify.Service;

import com.mayur.Slotify.Dtos.VenueDto;
import com.mayur.Slotify.Exception.VenueNotFoundException;
import com.mayur.Slotify.Model.Venue;
import com.mayur.Slotify.Repository.VenueRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {
    private final VenueRepository venueRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public VenueService(VenueRepository venueRepository, ModelMapper modelMapper) {
        this.venueRepository = venueRepository;
        this.modelMapper = modelMapper;
    }

    public VenueDto addVenue(VenueDto venueDto) {
        Venue venue = modelMapper.map(venueDto, Venue.class);
        Venue savedVenue = venueRepository.save(venue);
        return modelMapper.map(savedVenue, VenueDto.class);
    }

    public List<VenueDto> getAllVenues() {
        List<Venue> venues = venueRepository.findAll();
        return venues.stream().map(venue -> modelMapper.map(venue, VenueDto.class)).toList();
    }

    public VenueDto getVenueById(Long venueId) throws VenueNotFoundException {
        Venue venue = venueRepository.findById(venueId)
                .orElseThrow(() -> new VenueNotFoundException("Venue not found with id: " + venueId));
        return modelMapper.map(venue, VenueDto.class);
    }

    @Transactional
    public VenueDto updateVenue(Long venueId, VenueDto venueDto) throws VenueNotFoundException {
        Venue venue = venueRepository.findById(venueId)
                .orElseThrow(() -> new VenueNotFoundException("Venue not found with id: " + venueId));

        if (venueDto.getName() != null) {
            venue.setName(venueDto.getName());
        }
        if (venueDto.getAddress() != null) {
            venue.setAddress(venueDto.getAddress());
        }
        if (venueDto.getCity() != null) {
            venue.setCity(venueDto.getCity());
        }
        if (venueDto.getState() != null) {
            venue.setState(venueDto.getState());
        }
        if (venueDto.getCountry() != null) {
            venue.setCountry(venueDto.getCountry());
        }
        if (venueDto.getPostalCode() != null) {
            venue.setPostalCode(venueDto.getPostalCode());
        }
        if (venueDto.getCapacity() != null) {
            venue.setCapacity(venueDto.getCapacity());
        }
        if (venueDto.getWheelchairAccessible() != null) {
            venue.setWheelchairAccessible(venueDto.getWheelchairAccessible());
        }
        if (venueDto.getGenderInclusiveRestrooms() != null) {
            venue.setGenderInclusiveRestrooms(venueDto.getGenderInclusiveRestrooms());
        }

        return modelMapper.map(venue, VenueDto.class);
    }

    public void deleteVenue(Long venueId) throws VenueNotFoundException {
        if (!venueRepository.existsById(venueId)) {
            throw new VenueNotFoundException("Venue not found with id: " + venueId);
        }
        venueRepository.deleteById(venueId);
    }
}
