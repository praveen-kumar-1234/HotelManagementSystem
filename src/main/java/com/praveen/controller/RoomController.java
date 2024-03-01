package com.praveen.controller;


import com.praveen.entity.Hotel;
import com.praveen.entity.Room;
import com.praveen.model.HotelModel;
import com.praveen.model.RoomModel;
import com.praveen.service.HotelService;
import com.praveen.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomController {


    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomService roomService;



    @PostMapping("/saveRoom")
    public Room saveRoom(@Valid @RequestBody RoomModel roomModel) {
        return roomService.saveRoom(roomModel);
    }

    @GetMapping("/roomById/{number}")
    public RoomModel getRoomById (@PathVariable int number) {
        return roomService.getRoomById(number);
    }


    @GetMapping("/availability/{number}")
    public String roomAvailability(@PathVariable int number){
        if( roomService.roomAvailability(number))
        {return "Available";}
        return "Not Available";
    }


    @PutMapping("/manage/{number}")
    public Room manageBookings(@PathVariable int number,@RequestBody RoomModel roomModel)
    {
        return roomService.manageBookings(number,roomModel);
    }

    @GetMapping("/hotelFromRoomId/{number}")
    public HotelModel roomassociatedHotel(@PathVariable int number){
        return roomService.getHotelFromRoomId(number);
    }

    @DeleteMapping("/deleteByRoomId/{number}")
    public void deleteRoom(@PathVariable int number)
    {
        roomService.deleteRoom(number);
    }










}
