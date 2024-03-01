package com.praveen.model;


import com.praveen.entity.Hotel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


public class RoomModel {

    private int number;

    @Positive(message = "Price must be a positive value")
    private double price;

    @NotBlank(message = "Booking status cannot be blank")
    private String bookingStatus;

    private String bookDate;

//    @NotBlank(message = "User name cannot be blank")
    private String userName;

//    @NotBlank(message = "Address cannot be blank")
    private String address;

    @Positive(message = "User rating must be a positive value")
    private int userRating;

    @Size(max = 15, message = "User review must be less than 15 characters")
    private String userReview;



    private Hotel hotel;

    public RoomModel() {
    }



    public RoomModel(int number, double price, String bookingStatus, String userName, String address, int userRating, String userReview) {
        this.number = number;
        this.price = price;
        this.bookingStatus = bookingStatus;
        this.userName = userName;
        this.address = address;
        this.userRating = userRating;
        this.userReview = userReview;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public String getUserReview() {
        return userReview;
    }

    public void setUserReview(String userReview) {
        this.userReview = userReview;
    }
}
