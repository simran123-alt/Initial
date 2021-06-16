package com.example.demo.controller;

import com.example.demo.model.Room;
import com.example.demo.repository.RoomSearchRepository;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
//@Controller
public class MyController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomSearchRepository roomSearch;

    @GetMapping("/showRooms")
    public List<Room> findRooms() {

        List<Room> roomList = roomService.findAll();

        //model.addAttribute("rooms", rooms);

        return roomList;
    }

    @GetMapping("/showAvailableRooms")
    public List<Room> findVacantRooms()
    //@RequestParam(value = "status", required = false) boolean status)
    {
        //List<Room> roomVacantList = roomSearch.findRoomByStatus(true);
        return roomSearch.findRoomByStatus(true);
    }

    @GetMapping("/bookRoom")
    public String bookRoom() {
        List<Room> roomVacantLis = roomSearch.findRoomByStatus(true);
        Random rand = new Random();
        Room randomRoom = roomVacantLis.get(rand.nextInt(roomVacantLis.size()));
        Long roomID = randomRoom.getId();
        //boolean value=false;
        //Room updateRoom = roomSearch.
        //int updateRoomSetStatusForId(value,roomID);
        randomRoom.setBooked(false);
        roomSearch.save(randomRoom);
        return "Room No. "+roomID+" booked";
    }

    @GetMapping("/updateStatusOfRoom")
    public String updateRoomStatus(@Param("status") boolean status, @Param("id") Long id) {
        //Room roomUpdated = roomSearch.
        //roomSearch.updateRoomSetStatusForId(status,id);
        Room updateRoom =roomSearch.getOne(id);
        updateRoom.setStatus(status);
        roomSearch.save(updateRoom);
        //roomSearch.save();
        //int roomSearch.updateRoomSetStatusForId(status,id);
        return "Status changed for ID: "+id+" to "+status;
    }

}

/*
    List<Integer> givenList = Arrays.asList(1, 2, 3);
    Random rand = new Random();
    int randomElement = givenList.get(rand.nextInt(givenList.size()));

 */
