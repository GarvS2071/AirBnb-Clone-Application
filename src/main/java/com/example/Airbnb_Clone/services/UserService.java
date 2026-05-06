package com.example.Airbnb_Clone.services;

import com.example.Airbnb_Clone.model.User;

public interface UserService {
    User getUserById(Long id);
    void updateProfile(ProfileUpdateRequestDto profileUpdateRequestDto);
    UserDto getMyProfile();
}
