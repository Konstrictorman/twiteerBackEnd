package co.edu.escualing.twitter.services;

import co.edu.escualing.twitter.model.Like;

public interface ILikeService {

	public void createLike(Like like);
	public boolean removeLike(Like like);
}
