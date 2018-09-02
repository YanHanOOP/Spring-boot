package com.example.Test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Test.entity.User;
import com.example.Test.service.IUserService;

@Controller
@RequestMapping(path = "/")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@GetMapping(path="/list")
    public String list(Model model) {
        List<User> users=userService.getAllUsers();
        model.addAttribute("users", users);
        return "list";
    }
	
	@RequestMapping("/index")
    public String index() {
        return "index";
    }
	
	@RequestMapping("/teacher")
    public String teacher() {
        return "teacher";
    }
	
	@RequestMapping("/course")
    public String course() {
        return "course";
    }
	
	@RequestMapping("/addcourse")
    public String addcourse() {
        return "addcourse";
    }
	
	
	@RequestMapping("/register")
    public String register(){
        return "register";
    }

	
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

	@RequestMapping("/loginVerify")
	public String login(HttpServletRequest request){
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(userService.getByUsernameAndPassword(username, password) == null){
        	return "redirect:/login";
        }
        else
        	return "redirect:/index";
	}
	
	@RequestMapping("/registerVerify")
    public String register(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        if (password.equals(password2) && username != null && password != null){
            User user = new User();
            //user.setId(userService.getMaxId() + 1);
            user.setUsername(username);
            user.setPassword(password);
            user.setAccount(0);
            userService.save(user);
            return "redirect:/login";
        }else {
            return "redirect:/register";
        }
    }

	
	
	@RequestMapping("/delete")
    public String delete(String username) {
        userService.deleteUser(username);
        return "redirect:/list";
    }
	
}
