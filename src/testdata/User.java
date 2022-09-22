package testdata;

import util.Reader;

public class User {
	private String username;
	private String password;
	private String username_invalid_1;
	private String password_invalid_1;
	private String username_invalid_2;
	private String password_invalid_2;
	
	public User(String fileName) {
		this.username = Reader.json(fileName).get("username").toString();
		this.password = Reader.json(fileName).get("password").toString();
		this.username_invalid_1 = Reader.json(fileName).get("username_invalid_1").toString();
		this.password_invalid_1 = Reader.json(fileName).get("password_invalid_1").toString();
		this.username_invalid_2 = Reader.json(fileName).get("username_invalid_2").toString();
		this.password_invalid_2 = Reader.json(fileName).get("password_invalid_2").toString();
	}
	
	public void setUserName(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return this.username;
	}
	public String getPassword() {
		return this.password;
	}
	
	public void setUserName_invalid_1(String username_invalid_1) {
		this.username_invalid_1 = username_invalid_1;
	}
	public void setPassword_invalid_1(String password_invalid_1) {
		this.password_invalid_1 = password_invalid_1;
	}
	public String getUserName_invalid_1() {
		return this.username_invalid_1;
	}
	public String getPassword_invalid_1() {
		return this.password_invalid_1;
	}
	
	public void setUserName_invalid_2(String username_invalid_2) {
		this.username_invalid_2 = username_invalid_2;
	}
	public void setPassword_invalid_2(String password_invalid_2) {
		this.password_invalid_2 = password_invalid_2;
	}
	public String getUserName_invalid_2() {
		return this.username_invalid_2;
	}
	public String getPassword_invalid_2() {
		return this.password_invalid_2;
	}
}
