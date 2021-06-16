package com.example.demo.model;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//public class Room {
//}
@Entity
@Data
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean status;
     Long getRoomID()
     {
         return id;
     }
     void cancel()
     {
         status = false;
     }
     boolean isBooked()
     {
         return status;
     }
     public void setBooked(boolean status)
     {
         this.status = status;
     }





}
