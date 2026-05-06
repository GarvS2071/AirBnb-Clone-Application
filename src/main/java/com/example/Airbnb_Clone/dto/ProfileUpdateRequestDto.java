package com.example.Airbnb_Clone.dto;

import com.example.Airbnb_Clone.model.enums.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileUpdateRequestDto {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
}
