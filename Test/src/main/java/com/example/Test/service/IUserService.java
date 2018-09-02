package com.example.Test.service;

import java.util.List;
import com.example.Test.entity.User;


public interface IUserService {
	List<User> getAllUsers();
	void deleteUser(String username);
	User getByUsername(String username);
	User getByUsernameAndPassword(String username, String password);
	void save(User user);
	Integer getMaxId();
}
