package com.example.Airbnb_Clone.repository;

import com.example.Airbnb_Clone.model.Hotel;
import com.example.Airbnb_Clone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByOwner(User user);
}