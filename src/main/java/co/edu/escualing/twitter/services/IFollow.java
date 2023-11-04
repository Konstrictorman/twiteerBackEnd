package co.edu.escualing.twitter.services;

import co.edu.escualing.twitter.model.User;

public interface IFollow {

	public void follow(String idUser, User toFollow);
	public void unFollow(String idUser, User toUnFollow);
}
