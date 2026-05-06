package com.example.Airbnb_Clone.services;

public interface RooomService {
    RoomDto createNewRoom(Long hotelId, RoomDto RoomDto);
    List<RoomDto> getAllRoomsByHotelId(Long hotelId);
    RoomDto getRoomById(Long roomId);
    void deleteRoomById(Long roomId);
    RoomDto updateRoomById(Long hotelId, Long roomId, RoomDto roomDto);
}
