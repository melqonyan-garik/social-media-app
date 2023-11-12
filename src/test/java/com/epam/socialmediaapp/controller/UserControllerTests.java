package com.epam.socialmediaapp.controller;
import com.epam.socialmediaapp.service.MessageService;
import com.epam.socialmediaapp.service.PostService;
import com.epam.socialmediaapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserControllerTests {

    @Mock
    private UserService userService;

    @Mock
    private PostService postService; // Assuming you also inject PostService for UserController

    @Mock
    private MessageService messageService; // Assuming you also inject MessageService for UserController

    @InjectMocks
    private UserController userController;

    @Test
    void followUser_Success()  {
        Mockito.doNothing().when(userService).followUser(Mockito.anyLong(), Mockito.anyLong());

        ResponseEntity<String> response = userController.followUser(1L, 2L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User followed successfully", response.getBody());
    }


}

