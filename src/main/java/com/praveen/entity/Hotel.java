package com.praveen.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jdk.jfr.DataAmount;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Hotel
{
    @Id
   private int hotelId;

    @Length(min=5,max = 5,message = "name should be 5 characters only")
   private String name;

    @NotEmpty(message = "Location cannot be empty")
   private String location;

   @OneToMany(mappedBy = "hotel",cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                                            CascadeType.DETACH,CascadeType.REFRESH} )
   @JsonIgnore
   private List<Room> rooms;

    public Hotel() {
    }

    public Hotel(String name, String location) {
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

    public List<Room> getRooms() {

        return rooms;
    }

    public void setRooms(List<Room> rooms) {

        this.rooms = rooms;
    }



}