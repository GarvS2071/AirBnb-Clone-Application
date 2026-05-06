package com.example.Airbnb_Clone.dto;

import com.example.Airbnb_Clone.model.User;
import com.example.Airbnb_Clone.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestDto {
    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;
}
