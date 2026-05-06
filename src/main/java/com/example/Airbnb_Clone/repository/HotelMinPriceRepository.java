package com.example.Airbnb_Clone.repository;

import com.example.Airbnb_Clone.model.Hotel;
import com.example.Airbnb_Clone.model.HotelMinPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface HotelMinPriceRepository extends JpaRepository<HotelMinPrice, Long> {
    @Query(value = """
            SELECT new com.codecomet.projects.Airbnb_Clone.dto.HotelPriceDto(i.hotel, AVG(i.price))
            FROM HotelMinPrice in 
            WHERE
                i.hotel.city = :city
                AND i.date BETWEEN :startDate AND :endDate
                AND i.hotel.active = true
            GROUP BY i.hotel
""")
    List<HotelPriceDto> findHotelsWithAvailabileInventory(
            @Param("city") String city,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("roomsCount") Integer roomsCount,
            @Param("dateCount") Long dateCount
    );
    Optional<HotelMinPrice> findByHotelAndDate(Hotel hotel, LocalDate date);
}