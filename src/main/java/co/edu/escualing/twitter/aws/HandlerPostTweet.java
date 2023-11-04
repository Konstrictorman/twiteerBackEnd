package co.edu.escualing.twitter.aws;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import co.edu.escualing.twitter.model.Tweet;
import co.edu.escualing.twitter.services.impl.TweetService;

public class HandlerPostTweet implements RequestHandler<Map<String,String>, Tweet> {

	@Override
	public Tweet handleRequest(Map<String, String> input, Context context) {
		if (input.size() != 2) {
			throw new IllegalArgumentException("Input must be a list that contains 2 numbers.");
		}
		String usrName = input.get("userName");
		if (usrName ==  null) {
			throw new IllegalArgumentException("Input must be have a \"userName\" key.");
		}
		
		String msg = input.get("message");
		if (msg == null) {
			throw new IllegalArgumentException("Input must be have a \"message\" key.");
		}
		
		context.getLogger().log("Invoking postTweet using... "+ usrName + " and " + msg);
		
		
		TweetService ts = new TweetService();
		return ts.post(usrName, msg); 
	}

}
