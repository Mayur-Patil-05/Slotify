package com.mayur.Slotify.Dtos;

import java.time.LocalDateTime;
import java.util.List;

public class AttendeeDto {
    private Long attendeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDateTime registerAt;
    private Long eventId;
    private List<Long> ticketIds;

    public AttendeeDto() {
    }

    public AttendeeDto(Long attendeeId, String firstName, String lastName, String email, String phone, LocalDateTime registerAt, Long eventId, List<Long> ticketIds) {
        this.attendeeId = attendeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.registerAt = registerAt;
        this.eventId = eventId;
        this.ticketIds = ticketIds;
    }

    public Long getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(Long attendeeId) {
        this.attendeeId = attendeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(LocalDateTime registerAt) {
        this.registerAt = registerAt;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }
}
