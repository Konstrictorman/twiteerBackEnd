package co.edu.escualing.twitter.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.escualing.twitter.data.TwitterDAO;
import co.edu.escualing.twitter.model.Like;
import co.edu.escualing.twitter.model.Tweet;
import co.edu.escualing.twitter.model.User;
import co.edu.escualing.twitter.services.ITweetService;

public class TweetService implements ITweetService {
	
	private static Logger logger = LoggerFactory.getLogger(TweetService.class);

	@Override
	public Tweet getTweet(String tweetId) {
		Tweet tweet = null;
		TwitterDAO dao = new TwitterDAO();
		try {
			List<Tweet> list = dao.getTweets();
			Predicate<Tweet> byId = tuit -> tuit.getId().equals(tweetId);
			tweet = list.stream().filter(byId).findAny().orElse(null);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return tweet;
	}

	@Override
	public List<Tweet> getTweets() {
		TwitterDAO dao = new TwitterDAO();
		List<Tweet> tweets = null;
		try {
			tweets = dao.getTweets();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return tweets;
	}
	

	@Override
	public List<Tweet> getTweetsByPage(int offset, int limit) {
		List<Tweet> tweets = new ArrayList<Tweet>();
		try {
			if (offset < 0) return tweets;
			if (limit <=0) return tweets;
			
			tweets = getTweets();
			int length = tweets.size();
			int from = offset * limit;
			int aux = limit + from ;
			int to = aux > length ? length : aux;
			
			return tweets.subList(from, to);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return tweets;
		}		
	}
	
	@Override
	public List<Like> getLikes(String tweetId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tweet> getReplies(String tweetId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tweet> getRetweets(String tweetId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void retweet(String userId, String tweetId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tweet post(String user, String message) {
		Tweet tweet = null;
		try {
			tweet = new Tweet("101", new User(user), message, new Date());
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return tweet;
	}

	public static void main(String[] args) {
		TweetService ts = new TweetService();
		
		
		try {
			
			//Tweet tuit = ts.getTweet("35");
			Tweet tuit = ts.post("@Konstrictorman", "Mensaje de prueba");
			logger.info(tuit.toString());
			
			
			//List<Tweet> list = ts.getTweets();
			/*
			List<Tweet> list = ts.getTweetsByPage(0,10);
			Iterator<Tweet> it = list.iterator();
			while (it.hasNext()) {
				Tweet t = it.next();
				logger.info(t.toString());
			}
			*/
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

	}



}
