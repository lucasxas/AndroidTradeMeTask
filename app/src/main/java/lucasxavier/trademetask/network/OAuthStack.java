package lucasxavier.trademetask.network;

import com.android.volley.toolbox.HurlStack;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
 
public class OAuthStack extends HurlStack{
    private final OAuthConsumer consumer;
    public OAuthStack(OAuthConsumer consumer) {
        this.consumer = consumer;
    }
 
    @Override
    protected HttpURLConnection createConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            consumer.sign(connection);
        } catch (OAuthMessageSignerException |
                 OAuthExpectationFailedException |
                 OAuthCommunicationException e) {
            e.printStackTrace();
        }
        return connection;
    }
}