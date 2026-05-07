package com.example.Airbnb_Clone.dto;

import com.example.Airbnb_Clone.annotation.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class SignUpRequestDto {
    @Email
    @NotBlank
    private String email;
    @ValidPassword
    @NotBlank
    private String password;
    @NotBlank
    private String name;
}
