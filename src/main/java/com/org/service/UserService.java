package com.org.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.org.model.UserModel;

@Service
public class UserService {
	private ArrayList<UserModel> al = new ArrayList<UserModel>();
	private HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>(); // HashMap is used for searching the User in time complexity O(1)
	
	public UserModel getUser(int userID) {
		Integer indx = hm.get(userID);
		if(indx != null) {
			return al.get(indx);
		}else {
			return null;
		}	
	}
	
	public int addUser(UserModel um) {
		int userID = um.getUserID();
		if(hm.containsKey(userID)) {
			return -1;
		}else {
			al.add(um);
			hm.put(um.getUserID(), al.size() - 1);
			return 1;
		}
	}
	
	public int modifyUserName(int userID, String userName) {
		Integer indx = hm.get(userID);
		if(indx != null) {
			UserModel um = al.get(indx);
			um.setUserName(userName);
			return 1;
		}else {
			return -1;
		}
	}
	
	public int modifyAge(int userID, int age) {
		Integer indx = hm.get(userID);
		if(indx != null) {
			UserModel um = al.get(indx);
			um.setAge(age);
			return 1;
		}else {
			return -1;
		}
	}
	
	public int deleteUser(int userID) {
		Integer indx = hm.get(userID);
		if(indx != null) {
			int lastIndexUserID = al.get(al.size() - 1).getUserID();
			al.set(indx, al.get(al.size() - 1)); // Swapping the values to reduce time complexity while deleting values from middle of the ArrayList
			hm.put(lastIndexUserID, indx);
			al.remove(al.size() - 1);
			hm.remove(userID);
			return 1;
		}else {
			return -1;
		}
	}
}
