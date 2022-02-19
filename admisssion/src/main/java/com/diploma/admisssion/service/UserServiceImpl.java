package com.diploma.admisssion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;

import com.diploma.admisssion.model.User;
import com.diploma.admisssion.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		if(checkIfUserExist(user.getEmail()))
		{
			return null;
		}
		Base64.Encoder encoder = Base64.getEncoder();  
		user.setPwd(encoder.encodeToString(user.getPwd().getBytes()));
		user.setConfirmpwd(encoder.encodeToString(user.getConfirmpwd().getBytes()));
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	
	@Override
    public boolean checkIfUserExist(String email) {
        return userRepo.findByEmail(email) !=null ? true : false;
    }

}
