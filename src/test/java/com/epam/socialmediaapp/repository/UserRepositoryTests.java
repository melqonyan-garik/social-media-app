package com.epam.socialmediaapp.repository;
import com.epam.socialmediaapp.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUsername_ExistingUsername_ReturnsUser() {
        User user = new User("testuser", "test@example.com", "password");
        userRepository.save(user);

        Optional<User> foundUser = userRepository.findByUsername("testuser");

        assertTrue(foundUser.isPresent());
        assertEquals(user.getUsername(), foundUser.get().getUsername());
    }

    @Test
    void findByUsername_NonExistingUsername_ReturnsEmpty() {
        Optional<User> foundUser = userRepository.findByUsername("nonexistinguser");

        assertFalse(foundUser.isPresent());
    }


}
