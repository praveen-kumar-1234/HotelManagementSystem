package com.praveen.service;


import com.praveen.entity.Hotel;
import com.praveen.entity.Room;
import com.praveen.model.HotelModel;
import com.praveen.model.RoomModel;
import com.praveen.repo.HotelRepo;
import com.praveen.repo.RoomRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RoomServiceImp implements RoomService{

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private RoomRepo roomRepo;



    @Override
    public Room saveRoom(@Valid @RequestBody RoomModel roomModel) {
        Room room = modelToEntity(roomModel);
        return roomRepo.save(room);
    }

    @Override
    public RoomModel getRoomById(int id) {
        Room room = roomRepo.findById(id).orElse(null);
        return room != null ? entityToModel(room) : null;
    }

    @Override
    public HotelModel getHotelFromRoomId(int id)
    {
        Room room = roomRepo.findById(id).orElse(null);
        return entityToModel(room.getHotel());
    }


    @Override
    public boolean roomAvailability(int number) {
        Room room = roomRepo.findById(number).orElse(null);
        if (room != null && room.getBookingStatus().equalsIgnoreCase("Available")) {
            return true;
        }
        return false;
    }


    @Override
    public Room manageBookings(int number, RoomModel roomModel) {
        Room room = roomRepo.findById(number).orElse(null);
        if (room != null) {
            if (room.getBookingStatus().equalsIgnoreCase("Not Available")) {
                room.setBookDate(null);
                room.setUserName(null);
                room.setAddress(null);
                room.setUserRating(1);
                room.setUserReview(null);
            } else {
                room.setBookDate(roomModel.getBookDate());
                room.setUserName(roomModel.getUserName());
                room.setAddress(roomModel.getAddress());
                room.setUserRating(roomModel.getUserRating());
                room.setUserReview(roomModel.getUserReview());
            }
            return roomRepo.save(room);
        }
        return null;
    }


    public void deleteRoom(int id)
    {
        roomRepo.deleteById(id);
    }


    public Hotel modelToEntity(HotelModel model) {
        Hotel entity = new Hotel();
        entity.setHotelId(model.getHotelId());
        entity.setName(model.getName());
        entity.setLocation(model.getLocation());
        // You may set other properties as needed

        return entity;
    }

    public HotelModel entityToModel(Hotel entity) {
        HotelModel model = new HotelModel();
        model.setHotelId(entity.getHotelId());
        model.setName(entity.getName());
        model.setLocation(entity.getLocation());
        // You may get other properties as needed
        return model;
    }




    public Room modelToEntity(RoomModel model) {
        Room entity = new Room();
        entity.setNumber(model.getNumber());
        entity.setPrice(model.getPrice());
        entity.setBookingStatus(model.getBookingStatus());
        entity.setBookDate(model.getBookDate());
        entity.setUserName(model.getUserName());
        entity.setAddress(model.getAddress());
        entity.setUserRating(model.getUserRating());
        entity.setUserReview(model.getUserReview());
        return entity;
    }

    public RoomModel entityToModel(Room entity) {
        RoomModel model = new RoomModel();
        model.setNumber(entity.getNumber());
        model.setPrice(entity.getPrice());
        model.setBookingStatus(entity.getBookingStatus());
        model.setBookDate(entity.getBookDate());
        model.setUserName(entity.getUserName());
        model.setAddress(entity.getAddress());
        model.setUserRating(entity.getUserRating());
        model.setUserReview(entity.getUserReview());
        return model;
    }

}
