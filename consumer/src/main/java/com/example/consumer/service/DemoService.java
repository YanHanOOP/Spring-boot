package com.example.consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.consumer.entity.Teacher;





@Service
public class DemoService {
	@Autowired
    RestTemplate restTemplate;
	
    public String consuService(String name) {
        return restTemplate.getForObject("http://Producer/product?name="+name,String.class);
    }
    
    public List<Teacher> teacherService(){
    	List<Teacher> list = restTemplate.getForObject("http://Producer/teacher", List.class);
    	return list;
    }
    
}
