package co.edu.escualing.twitter.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Tweet {
	
	//private static SimpleDateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	

	public Tweet() {
		super();
	}	
	
	
	public Tweet(String id, User author, String message, Date date) {
		super();
		this.id = id;
		this.author = author;
		this.message = message;
		this.date = date;
	}
	
	public Tweet(String id, User author, String message, String date) throws Exception {
		this(id, author, message, dateFormat.parse(date));
	}

	public Tweet(String id, User author, String message, List<Like> likes, List<Tweet> replies, List<User> retweets,
			Date date) {
		super();
		this.id = id;
		this.author = author;
		this.message = message;
		this.likes = likes;
		this.replies = replies;
		this.retweets = retweets;
		this.date = date;
	}


	private String id;
	private User author;
	private String message;
	private List<Like> likes;
	private List<Tweet> replies;
	private List<User> retweets;
	private Date date;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}	
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Like> getLikes() {
		return likes;
	}
	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}
	public List<Tweet> getReplies() {
		return replies;
	}
	public void setReplies(List<Tweet> replies) {
		this.replies = replies;
	}
	public List<User> getRetweets() {
		return retweets;
	}
	public void setRetweets(List<User> retweets) {
		this.retweets = retweets;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Tweet [id=" + id + ", author=" + author + ", message=" + message + ", likes=" + likes + ", replies="
				+ replies + ", retweets=" + retweets + ", date=" + date + "]";
	}
	
	
	

}
