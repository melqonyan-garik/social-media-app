package com.epam.socialmediaapp.dto;

import lombok.Data;

@Data
public class PostRequest {
    private String content;
    private Long userId;

}