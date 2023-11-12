package com.epam.socialmediaapp.controller;

import com.epam.socialmediaapp.dto.PostRequest;
import com.epam.socialmediaapp.model.Post;
import com.epam.socialmediaapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService; // Assuming you have a PostService to handle post-related operations

    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestBody PostRequest postRequest) {
        postService.createPost(postRequest);
        return new ResponseEntity<>("Post created successfully", HttpStatus.CREATED);

    }

    @GetMapping("/timeline/{userId}")
    public ResponseEntity<List<Post>> getUserTimeline(@PathVariable Long userId) {
        List<Post> timeline = postService.getUserTimeline(userId);
        return new ResponseEntity<>(timeline, HttpStatus.OK);

    }
}

