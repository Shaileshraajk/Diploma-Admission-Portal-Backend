package com.diploma.admisssion.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diploma.admisssion.model.User;
import com.diploma.admisssion.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserContoller {
	@Autowired
	private UserService userservice;
	
	@PostMapping("/add")
	public String add(@RequestBody User user) {
		if(userservice.saveUser(user)!=null)
		{
			return "User added successfully";
		}
		return "User already exits";
	}
	
	@GetMapping("/getAll")
	public List<User> list(){
        return userservice.getAllUsers();
    }
	

}