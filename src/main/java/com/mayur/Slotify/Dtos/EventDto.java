package com.mayur.Slotify.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mayur.Slotify.Enum.EventCategory;
import com.mayur.Slotify.Model.Venue;

import java.time.LocalDateTime;
import java.util.List;

public class EventDto {
    private Long eventId;
    private String title;
    private String description;
    private String location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String organizer;
    private EventCategory category;
    private Venue venue;
    private List<Long> attendeeIds;
    private List<Long> ticketIds;

    public EventDto() {
    }

    public EventDto(Long eventId, String title, String description, String location, LocalDateTime startTime, LocalDateTime endTime, String organizer, EventCategory category, Venue venue, List<Long> attendeeIds, List<Long> ticketIds) {
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.organizer = organizer;
        this.category = category;
        this.venue = venue;
        this.attendeeIds = attendeeIds;
        this.ticketIds = ticketIds;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<Long> getAttendeeIds() {
        return attendeeIds;
    }

    public void setAttendeeIds(List<Long> attendeeIds) {
        this.attendeeIds = attendeeIds;
    }

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }
}
