package com.example.Airbnb_Clone.dto;

import com.example.Airbnb_Clone.model.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelPriceDto {
    private Hotel hotel;
    private Double price;
}
