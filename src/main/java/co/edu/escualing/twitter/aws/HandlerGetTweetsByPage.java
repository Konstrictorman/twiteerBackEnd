package co.edu.escualing.twitter.aws;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import co.edu.escualing.twitter.model.Tweet;
import co.edu.escualing.twitter.services.impl.TweetService;

public class HandlerGetTweetsByPage implements RequestHandler<List<Integer>, List<Tweet>> {

	@Override
	public List<Tweet> handleRequest(List<Integer> input, Context context) {
		context.getLogger().log("Invoking getTweetsByPage using... "+ input);
		
		TweetService ts = new TweetService();
		if (input == null || input.size() == 0) {
			return ts.getTweets();
		}

		int offset = input.get(0);
		int limit = input.get(1);
		return ts.getTweetsByPage(offset, limit);		
	}

}
