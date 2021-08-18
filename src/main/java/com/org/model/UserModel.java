package com.org.model;

public class UserModel {
	
	private int userID;
	private String userName;
	private int age;
	public UserModel() {
		super();
	}
	public UserModel(int userID, String userName, int age) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.age = age;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userId) {
		this.userID = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", age=" + age + "]";
	}
}
