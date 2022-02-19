package com.diploma.admisssion.service;

import java.util.List;

import com.diploma.admisssion.model.User;

public interface UserService {
	
	public User saveUser(User user);
	
    public List<User> getAllUsers();
    
    public boolean checkIfUserExist(String email);

}
