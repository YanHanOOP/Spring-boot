package com.example.Test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Test.entity.Message;
import com.example.Test.service.MessageService;


@Controller
@RequestMapping(path = "/")
public class MessageController {
      
	@Autowired
	private MessageService messageService;
     
	@GetMapping(path="/listAll")
	public String listAll(Model model) {
        List<Message> messageEntitys=messageService.getAllMessages();
        model.addAttribute("messageEntitys", messageEntitys);
        return "listAll";
    }
	
	@RequestMapping("/messageBoard")
    public String index() {
        return "messageBoard";
    }
	
	@RequestMapping("/deleteMessage")
    public String delete(Integer id) {
        messageService.deleteMessage(id);
        return "redirect:/listAll";
    }
	
	@RequestMapping("/messageVerify")
	public String message(HttpServletRequest request){
		
		String username = request.getParameter("username");
        String message = request.getParameter("message");
        //判断是否有该用户名
        messageService.saveMessage(username, message);
        
        return "redirect:/listAll";
	}
	
    
}
