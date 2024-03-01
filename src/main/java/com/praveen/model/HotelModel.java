package com.praveen.model;


import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class HotelModel
{
    private int hotelId;

    @Length(min=5,max = 5,message = "name should be 5 characters only")
    private String name;

    @NotEmpty(message = "Location cannot be empty")
    private String location;

    public HotelModel() {
    }

    public HotelModel(int hotelId, String name, String location) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
    }


    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}