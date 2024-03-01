package com.praveen.controller;


import com.praveen.entity.Hotel;
import com.praveen.entity.Room;
import com.praveen.model.HotelModel;
import com.praveen.model.RoomModel;
import com.praveen.service.HotelService;
import com.praveen.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
        @Autowired
       private HotelService hotelService;

        @Autowired
        private RoomService roomService;


    @PostMapping("/saveHotel")
    @Secured("ROLE_ADMIN")
    public Hotel saveHotel(@Valid @RequestBody HotelModel hotelModel) {
        return hotelService.saveHotel(hotelModel);
    }

    @GetMapping("/findAllHotels")
    public List<HotelModel> getAllHotels(){
        return hotelService.getAllHotels();
    }


    @GetMapping("/{hotelId}")
    public HotelModel getHotelById(@PathVariable int hotelId) {
        return hotelService.getHotelById(hotelId);
    }

    @PostMapping("/addRoom/{hotelId}")
    public Room addRoom(@PathVariable int hotelId,@RequestBody RoomModel roomModel){
        return hotelService.addRoom(hotelId,roomModel);
    }

    @GetMapping("/viewRooms/{hotelId}")
    public List<Room> viewRoomsinHotel(@PathVariable int hotelId)
    {
        return hotelService.viewRoom(hotelId);
    }

    @PutMapping("/update/{hotelId}")
    public Hotel updateHotel(@PathVariable int hotelId,@RequestBody  HotelModel updatedHotelModel)
    {
        return hotelService.updateHotel(hotelId,updatedHotelModel);

    }

    @DeleteMapping("/delete/{hotelId}")
    public void  deleteHotel(@PathVariable int hotelId)
    {
         hotelService.deleteHotel(hotelId);
    }




//    }





}
