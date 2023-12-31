package com.epam.socialmediaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegistrationRequest {

    private String username;
    private String email;
    private String password;
}
