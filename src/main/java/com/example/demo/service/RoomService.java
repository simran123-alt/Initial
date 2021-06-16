package com.example.demo.service;

import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.RoomSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomService implements IRoomService{
    @Autowired
    private RoomRepository repository;

   // private RoomSearchRepository repo;

    @Override
    public List<Room> findAll() {

        var rooms = (List<Room>) repository.findAll();

        return rooms;
    }



}
