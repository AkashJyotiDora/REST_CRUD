package com.org.controller;



import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.UserModel;
import com.org.service.UserService;

@RestController
public class MyController {
	
	@Autowired
	UserService us;
	
	@GetMapping("/users/{userID}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserModel getUser(@PathVariable int userID) {
		UserModel user = us.getUser(userID);
		return user;
	}
	
	@PostMapping("/users/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addUser(@RequestBody UserModel um) {
		int ret = us.addUser(um);
		if(ret == 1) {
			return "User added successfully";
		}else {
			return "Duplicate UserID given";
		}
	}
	
	@PutMapping("/users/modify/{userID}/name/{userName}")
	@Produces(MediaType.TEXT_PLAIN)
	public String modifyUserName(@PathVariable int userID, @PathVariable String userName) {
		int ret = us.modifyUserName(userID, userName);
		if(ret == 1) {
			return "User Name modified successfully";
		}else {
			return "User Not Found";
		}
	}
	
	@PutMapping("/users/modify/{userID}/age/{age}")
	@Produces(MediaType.TEXT_PLAIN)
	public String modifyAge(@PathVariable int userID, @PathVariable int age) {
		int ret = us.modifyAge(userID, age);
		if(ret == 1) {
			return "User Age modified successfully";
		}else {
			return "User Not Found";
		}
	}
	
	@DeleteMapping("/users/delete/{userID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUser(@PathVariable int userID) {
		int ret = us.deleteUser(userID);
		if(ret == 1) {
			return "User deleted successfully";
		}else {
			return "User Not Found";
		}
	}
}
