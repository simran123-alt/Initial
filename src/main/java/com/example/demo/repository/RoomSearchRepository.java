package com.example.demo.repository;

import com.example.demo.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RoomSearchRepository extends JpaRepository<Room, Long>{

    @Query("SELECT r FROM Room r WHERE r.status = ?1")
    List<Room> findRoomByStatus(boolean status);

    @Modifying
    @Query("update Room r set r.status = :status where r.id = :id")
    int updateRoomSetStatusForId(@Param("status") boolean status, @Param("id") Long id);

}








//Controller
    /*
    @GetMapping(value = "/hotel/search")
    public String getHotels(@RequestParam(value = "state", required = false) String state,
                            @RequestParam(value = "suburb", required = false) String suburb,
                            @RequestParam(value = "postcode", required = false) String postcode,
                            Pageable pageable, Model model) {
        Page<Hotel> results = hotelRepository.findAllByLocation(state, suburb, postcode, pageable);
        model.addAttribute("hotels", results == null ? Page.empty() : results);
        return "/hotel/hotels";
    }
    */

//Repository
    /*
    @Query("select h from Hotel h " +
            "where upper(h.address.state) = coalesce(upper(:state), upper(h.address.state)) " +
            "and upper(h.address.suburb) = coalesce(upper(:suburb), upper(h.address.suburb)) " +
            "and h.address.postcode.value = coalesce(:postcode, h.address.postcode.value)"
    )
    Page<Hotel> findAllByLocation(@Param("state") String state,
                                  @Param("suburb") String suburb,
                                  @Param("postcode") String postcode,
                                  Pageable pageable);
                                  */
