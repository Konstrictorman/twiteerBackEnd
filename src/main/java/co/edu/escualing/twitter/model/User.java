package co.edu.escualing.twitter.model;

import java.util.List;

public class User {
	private String id;
	private String userName;	
	private String pwd;
	private String mail;
	private String avatar;
	private List<User> followers;
	private List<User> following;
	
	
	
	public User() {
		super();
	}
	
	
	
	public User(String userName) {
		super();
		this.userName = userName;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public List<User> getFollowers() {
		return followers;
	}
	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}
	public List<User> getFollowing() {
		return following;
	}
	public void setFollowing(List<User> following) {
		this.following = following;
	}



	@Override
	public String toString() {
		return "User [userName=" + userName + "]";
	}
	
	
	
}
