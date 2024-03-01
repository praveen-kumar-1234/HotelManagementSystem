package com.praveen.service;

import com.praveen.entity.Hotel;
import com.praveen.entity.Room;
import com.praveen.model.HotelModel;
import com.praveen.model.RoomModel;

import java.util.List;

public interface HotelService {


    Hotel saveHotel(HotelModel model);

    List<HotelModel> getAllHotels();

    HotelModel getHotelById(int id);

    Room addRoom(int hotelId, RoomModel roomModel);

    List<Room> viewRoom(int hotelId);

    Hotel updateHotel(int hotelId, HotelModel updatedHotelModel);
    void deleteHotel(int hotelId);
    Hotel modelToEntity(HotelModel model);
    HotelModel entityToModel(Hotel entity);

    Room modelToEntity(RoomModel model);
    RoomModel entityToModel(Room entity);

}
