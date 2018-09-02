package com.example.Test.service;

import org.springframework.stereotype.Service;
import com.example.Test.entity.User;
import com.example.Test.repo.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserRepository userRepository;
	
	
	
	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void deleteUser(String username) {
		userRepository.delete(getByUsername(username));
	}

	@Override
	public User getByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User getByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public Integer getMaxId() {
		return userRepository.findMaxId();
	}

}
