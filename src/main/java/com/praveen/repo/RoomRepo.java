package com.praveen.repo;

import com.praveen.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepo extends JpaRepository<Room,Integer> {
}
