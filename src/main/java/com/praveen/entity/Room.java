package com.praveen.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int number;

    @Positive(message = "Price must be a positive value")
    private double price;

    @NotBlank(message = "Booking status cannot be blank")
    private String bookingStatus;

    private String bookDate;

    private String userName;
//    @NotBlank(message = "Address cannot be blank")
    private String address;
    @Positive(message = "User rating must be a positive value")
    private int userRating;

    @Size(max = 15, message = "User review must be less than 15 characters")
    private String userReview;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                            CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Room() {
    }


    public Room(double price, String bookingStatus, String bookDate, String userName, String address, int userRating, String userReview) {
        this.price = price;
        this.bookingStatus = bookingStatus;
        this.bookDate = bookDate;
        this.userName = userName;
        this.address = address;
        this.userRating = userRating;
        this.userReview = userReview;
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

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }


    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", price=" + price +
                ", bookingStatus='" + bookingStatus + '\'' +
                ", bookDate='" + bookDate + '\'' +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", userRating=" + userRating +
                ", userReview='" + userReview + '\'' +
                '}';
    }
}