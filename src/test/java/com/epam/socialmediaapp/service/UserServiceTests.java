package com.epam.socialmediaapp.service;
import com.epam.socialmediaapp.dto.UserRegistrationRequest;
import com.epam.socialmediaapp.dto.UserRequest;
import com.epam.socialmediaapp.model.User;
import com.epam.socialmediaapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void registerUser_Success()  {
        UserRegistrationRequest userRequest = new UserRegistrationRequest("testuser", "test@example.com", "password");

        Mockito.when(userRepository.existsByUsername(Mockito.anyString())).thenReturn(false);
        Mockito.when(userRepository.existsByEmail(Mockito.anyString())).thenReturn(false);
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(new User());

        userService.registerUser(userRequest);

        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any());
    }


}
