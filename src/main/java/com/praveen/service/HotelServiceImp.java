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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class HotelServiceImp implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;


    @Autowired
    private RoomRepo roomRepo;

    @Override
    public Hotel saveHotel(@Valid @RequestBody HotelModel model) {
        Hotel entity = modelToEntity(model);
        return hotelRepo.save(entity);
    }

    @Override
    public List<HotelModel> getAllHotels() {
        List<Hotel> entities = hotelRepo.findAll();
        List<HotelModel> models = new ArrayList<>();
        for (Hotel entity : entities) {
            models.add(entityToModel(entity));
        }
        return models;
    }

    @Override
    public HotelModel getHotelById(int id) {
        Hotel entity = hotelRepo.findById(id).orElse(null);
        return entity != null ? entityToModel(entity) : null;
    }

//    @Override
//    public Room addRoom(int hotelId, RoomModel roomModel) {
//        Hotel hotel = hotelRepo.findById(hotelId).get();
////       List<Room> rooms = new ArrayList<>();
////        Room room = roomService.modelToEntity(roomModel);
////       rooms.addAll((Collection)hotel.getRooms());
////       rooms.add(room);
////            hotel.setRooms(rooms);
////            room.setHotel(hotel);
////            return roomRepo.save(room);
//        List<Room> room1 = hotel.getRooms();
//        if(room1 == null){
//            room1 = new ArrayList<>();
//        }
//        Room room = roomService.modelToEntity(roomModel);
//        room1.add(room);
//        room.setHotel(hotel);
//       return roomRepo.save(room);
//    }

    @Override
    public Room addRoom(int hotelId, RoomModel roomModel) {
        Hotel hotel = hotelRepo.findById(hotelId).orElse(null);
        if (hotel == null) {
            // Handle the case when the hotel is not found
            return null;
        }

        Room room = modelToEntity(roomModel);
        room.setHotel(hotel);  // Set the hotel for the room

        // Update the hotel's list of rooms
        List<Room> rooms = hotel.getRooms();
        if (rooms == null) {
            rooms = new ArrayList<>();
            hotel.setRooms(rooms);
        }
        rooms.add(room);

        // Save the room
        return roomRepo.save(room);
    }


    @Override
    public List<Room> viewRoom(int hotelId) {
        Hotel hotel = hotelRepo.findById(hotelId).orElse(null);
        return hotel != null ? hotel.getRooms() : null;
    }

    @Override
    public Hotel updateHotel(int hotelId, HotelModel updatedHotelModel) {
        Hotel existingHotel = hotelRepo.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + hotelId));
        Hotel updatedHotelEntity = modelToEntity(updatedHotelModel);

        // Update existingHotel with values from updatedHotelEntity
        existingHotel.setName(updatedHotelEntity.getName());
        existingHotel.setLocation(updatedHotelEntity.getLocation());

        return hotelRepo.save(existingHotel);
    }

    @Override
    public void deleteHotel(int hotelId) {
        hotelRepo.deleteById(hotelId);
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
