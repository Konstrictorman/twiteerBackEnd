package co.edu.escualing.twitter.services;

import java.util.List;

import co.edu.escualing.twitter.model.User;

public interface IUserService {
	
	public List<User> getUsers();
	public void createUser(User user);
	public boolean updateUser(User user);
	public User getUser(String userId);
	public List<User> getFollowers(String userId);
	public List<User> getFolling(String userId);
	

}
