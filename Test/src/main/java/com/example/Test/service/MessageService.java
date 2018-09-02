package com.example.Test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Test.entity.Message;
import com.example.Test.repo.MessageRepository;

@Service
public class MessageService implements IMessageService{
         @Autowired
         private MessageRepository messageRepository;

		@Override
		public List<Message> getAllMessages() {
			return (List<Message>) messageRepository.findAll();
			
		}

		@Override
		public void deleteMessage(Integer id) {
			Optional<Message> messageEntity1;
			messageEntity1=messageRepository.findById(id);
			Message messageEntity;
			messageEntity=messageEntity1.get();
			messageRepository.delete(messageEntity);
			
		}

		@Override
		public Message getByUsername(String username) {
			
			return messageRepository.findByUsername(username);
		}

		@Override
		public Message getByUserId(Integer userId) {
			
			return messageRepository.findByUserId(userId);
		}

		@Override
		public void saveMessage(String username, String message) {
		
			Message messageEntity=new Message();
			messageEntity.setUsername(username);
			messageEntity.setMessage(message);
				
			messageRepository.save(messageEntity);					
		}

		@Override
		public Optional<Message> getById(Integer id) {
			
			return messageRepository.findById(id);
		}
               
}
