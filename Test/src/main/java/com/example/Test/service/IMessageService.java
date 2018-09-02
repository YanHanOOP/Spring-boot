package com.example.Test.service;

import java.util.List;
import java.util.Optional;

import com.example.Test.entity.Message;

public interface IMessageService {
     
	  List<Message> getAllMessages();
	  void deleteMessage(Integer id);
	  Message getByUsername(String username);
	  Message getByUserId(Integer userId);
	  void saveMessage(String username,String message);
	  Optional<Message> getById(Integer id);
}
