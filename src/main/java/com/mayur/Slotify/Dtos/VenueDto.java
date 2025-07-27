package com.mayur.Slotify.Dtos;

import java.util.List;

public class VenueDto {
    private Long venueId;
    private String name;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private Integer capacity;
    private Boolean wheelchairAccessible;
    private Boolean genderInclusiveRestrooms;
    private List<Long> eventIds;

    public VenueDto() {
    }

    public VenueDto(Long venueId, String name, String address, String city, String state, String country, String postalCode, Integer capacity, Boolean wheelchairAccessible, Boolean genderInclusiveRestrooms, List<Long> eventIds) {
        this.venueId = venueId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.capacity = capacity;
        this.wheelchairAccessible = wheelchairAccessible;
        this.genderInclusiveRestrooms = genderInclusiveRestrooms;
        this.eventIds = eventIds;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getWheelchairAccessible() {
        return wheelchairAccessible;
    }

    public void setWheelchairAccessible(Boolean wheelchairAccessible) {
        this.wheelchairAccessible = wheelchairAccessible;
    }

    public Boolean getGenderInclusiveRestrooms() {
        return genderInclusiveRestrooms;
    }

    public void setGenderInclusiveRestrooms(Boolean genderInclusiveRestrooms) {
        this.genderInclusiveRestrooms = genderInclusiveRestrooms;
    }

    public List<Long> getEventIds() {
        return eventIds;
    }

    public void setEventIds(List<Long> eventIds) {
        this.eventIds = eventIds;
    }
}
