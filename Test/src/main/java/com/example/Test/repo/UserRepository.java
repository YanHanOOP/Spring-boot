package com.example.Test.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.Test.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsernameAndPassword(String username, String password);
	User findByUsername(String username);
	
	@Query("select max(u.id) from User u")
	Integer findMaxId();
}
