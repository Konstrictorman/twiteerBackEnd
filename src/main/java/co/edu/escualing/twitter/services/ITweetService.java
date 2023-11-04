package co.edu.escualing.twitter.services;

import java.util.List;

import co.edu.escualing.twitter.model.Like;
import co.edu.escualing.twitter.model.Tweet;
import co.edu.escualing.twitter.model.User;

public interface ITweetService {
	
	public Tweet getTweet(String tweetId);
	public List<Tweet> getTweets();
	public List<Tweet> getTweetsByPage(int offset, int limit);
	public List<Like> getLikes(String tweetId);
	public List<Tweet> getReplies(String tweetId);
	public List<Tweet> getRetweets(String tweetId);
	public void retweet(String userId, String tweetId);
	public Tweet post(String user, String message);

}
