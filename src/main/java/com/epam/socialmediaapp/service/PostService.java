package com.epam.socialmediaapp.service;

import com.epam.socialmediaapp.dto.PostRequest;
import com.epam.socialmediaapp.model.Post;
import com.epam.socialmediaapp.model.User;
import com.epam.socialmediaapp.repository.PostRepository;
import com.epam.socialmediaapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository; // Assuming you have a PostRepository for database operations

    @Autowired
    private UserRepository userRepository; // Assuming you have a UserRepository for user-related operations

    public void createPost(PostRequest postRequest) {
        User user = getUserById(postRequest.getUserId()); // Assuming userId is part of PostRequest

        // Create a new post
        Post post = new Post(postRequest.getContent(), user);
        postRepository.save(post);
    }

    public List<Post> getUserTimeline(Long userId) {
        User user = getUserById(userId);


        return postRepository.findByUserInOrderByTimestampDesc(user.getFollowing());
    }

    private User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));
    }
}
