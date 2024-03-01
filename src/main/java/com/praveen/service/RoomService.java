package com.praveen.service;

import com.praveen.entity.Hotel;
import com.praveen.entity.Room;
import com.praveen.model.HotelModel;
import com.praveen.model.RoomModel;

public interface RoomService {


    Room saveRoom(RoomModel roomModel);

    RoomModel getRoomById(int id);

    boolean roomAvailability(int number);

    Room manageBookings(int number, RoomModel roomModel);

    Room modelToEntity(RoomModel model);
    RoomModel entityToModel(Room entity);

    HotelModel getHotelFromRoomId(int id);

    Hotel modelToEntity(HotelModel model);
    HotelModel entityToModel(Hotel entity);
    void deleteRoom(int id);
}
