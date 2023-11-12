package com.epam.socialmediaapp.controller;

import com.epam.socialmediaapp.dto.MessageRequest;
import com.epam.socialmediaapp.dto.UserRegistrationRequest;
import com.epam.socialmediaapp.model.Message;
import com.epam.socialmediaapp.model.Post;
import com.epam.socialmediaapp.service.MessageService;
import com.epam.socialmediaapp.service.PostService;
import com.epam.socialmediaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    @Autowired
    private MessageService messageService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest registrationRequest) {
        userService.registerUser(registrationRequest);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);

    }

    @PostMapping("/follow/{followerId}/{followingId}")
    public ResponseEntity<String> followUser(@PathVariable Long followerId, @PathVariable Long followingId) {

        userService.followUser(followerId, followingId);
        return new ResponseEntity<>("User followed successfully", HttpStatus.OK);

    }

    @PostMapping("/unfollow/{followerId}/{followingId}")
    public ResponseEntity<String> unfollowUser(@PathVariable Long followerId, @PathVariable Long followingId) {
        userService.unfollowUser(followerId, followingId);
        return new ResponseEntity<>("User unfollowed successfully", HttpStatus.OK);
    }

    @GetMapping("/timeline/{userId}")
    public ResponseEntity<List<Post>> getUserTimeline(@PathVariable Long userId) {
        List<Post> timeline = postService.getUserTimeline(userId);
        return new ResponseEntity<>(timeline, HttpStatus.OK);
    }

    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestBody MessageRequest messageRequest) {
        messageService.sendMessage(messageRequest);
        return new ResponseEntity<>("Message sent successfully", HttpStatus.CREATED);

    }

    @GetMapping("/messages/{userId}")
    public ResponseEntity<List<Message>> getUserMessages(@PathVariable Long userId) {
        List<Message> messages = messageService.getUserMessages(userId);
        return new ResponseEntity<>(messages, HttpStatus.OK);

    }
}

