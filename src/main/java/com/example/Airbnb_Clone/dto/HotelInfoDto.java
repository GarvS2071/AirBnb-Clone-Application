package com.example.Airbnb_Clone.dto;

import lombok.Data;

@Data
public class HotelInfoDto {
    private HotelDto hotel;
    private List<RoomDto> rooms;
}
