package com.epam.socialmediaapp.service;

import com.epam.socialmediaapp.dto.MessageRequest;
import com.epam.socialmediaapp.model.Message;
import com.epam.socialmediaapp.model.User;
import com.epam.socialmediaapp.repository.MessageRepository;
import com.epam.socialmediaapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository; // Assuming you have a MessageRepository for database operations

    @Autowired
    private UserRepository userRepository; // Assuming you have a UserRepository for user-related operations

    public void sendMessage(MessageRequest messageRequest) {
        User sender = getUserById(messageRequest.getSenderId());
        User receiver = getUserById(messageRequest.getReceiverId());

        Message message = new Message(sender, receiver, messageRequest.getContent());
        messageRepository.save(message);
    }

    public List<Message> getUserMessages(Long userId){
        User user = getUserById(userId);
        return messageRepository.findBySenderOrReceiverOrderByTimestampDesc(user, user);
    }

    private User getUserById(Long userId)  {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));
    }
}
