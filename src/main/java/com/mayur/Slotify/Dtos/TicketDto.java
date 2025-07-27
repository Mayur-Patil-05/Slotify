package com.mayur.Slotify.Dtos;

import com.mayur.Slotify.Enum.TicketStatus;
import com.mayur.Slotify.Enum.TicketType;

import java.time.LocalDate;

public class TicketDto {
    private Long ticketId;
    private String ticketNumber;
    private TicketType ticketType;
    private Double price;
    private String seatNumber;
    private LocalDate purchaseDate;
    private TicketStatus ticketStatus;
    private Long attendeeId;
    private Long eventId;

    public TicketDto() {
    }

    public TicketDto(Long ticketId, String ticketNumber, TicketType ticketType, Double price, String seatNumber, LocalDate purchaseDate, TicketStatus ticketStatus, Long attendeeId, Long eventId) {
        this.ticketId = ticketId;
        this.ticketNumber = ticketNumber;
        this.ticketType = ticketType;
        this.price = price;
        this.seatNumber = seatNumber;
        this.purchaseDate = purchaseDate;
        this.ticketStatus = ticketStatus;
        this.attendeeId = attendeeId;
        this.eventId = eventId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Long getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(Long attendeeId) {
        this.attendeeId = attendeeId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
