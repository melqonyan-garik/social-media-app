package com.epam.socialmediaapp.repository;

import com.epam.socialmediaapp.model.Post;
import com.epam.socialmediaapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.user IN :following ORDER BY p.timestamp DESC")
    List<Post> findByUserInOrderByTimestampDesc(@Param("following") Set<User> following);
}

