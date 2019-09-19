package com.ghale.services.room.roomService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room,Long> {
    Room findByRoomNumber(String roomNum);
    Room findByRoomId(long number);

}
