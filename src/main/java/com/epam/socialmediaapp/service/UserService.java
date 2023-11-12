package com.epam.socialmediaapp.service;

import com.epam.socialmediaapp.dto.UserRegistrationRequest;
import com.epam.socialmediaapp.model.User;
import com.epam.socialmediaapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void registerUser(UserRegistrationRequest userRequest) {
        User user = new User(
                userRequest.getUsername(),
                userRequest.getEmail(),
                userRequest.getPassword()
        );

        userRepository.save(user);
    }

    public void followUser(Long followerId, Long followingId) {
        User follower = getUserById(followerId);
        User following = getUserById(followingId);

        follower.getFollowing().add(following);
        userRepository.save(follower);
    }

    public void unfollowUser(Long followerId, Long followingId) {
        User follower = getUserById(followerId);
        User following = getUserById(followingId);

        follower.getFollowing().remove(following);
        userRepository.save(follower);
    }

    private User getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElse(null);
    }
}
