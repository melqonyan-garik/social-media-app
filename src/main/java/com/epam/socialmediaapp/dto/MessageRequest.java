package com.epam.socialmediaapp.dto;

import lombok.Data;

@Data
public class MessageRequest {
    private Long senderId;
    private Long receiverId;
    private String content;
}
