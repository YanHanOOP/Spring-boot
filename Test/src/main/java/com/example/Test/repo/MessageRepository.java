package com.example.Test.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.Test.entity.Message;

public interface MessageRepository extends CrudRepository<Message,Integer>{
      Message findByUsername(String username);
      Message findByUserId(Integer usserId);  
      Optional<Message> findById(Integer id);
}
