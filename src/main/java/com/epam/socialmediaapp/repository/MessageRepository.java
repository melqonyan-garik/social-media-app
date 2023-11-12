package com.epam.socialmediaapp.repository;

import com.epam.socialmediaapp.model.Message;
import com.epam.socialmediaapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query("SELECT m FROM Message m WHERE m.sender = :user OR m.receiver = :user ORDER BY m.timestamp DESC")
    List<Message> findBySenderOrReceiverOrderByTimestampDesc(@Param("user") User user);
}
