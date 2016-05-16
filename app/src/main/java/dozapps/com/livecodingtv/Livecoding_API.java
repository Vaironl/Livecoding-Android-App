package dozapps.com.livecodingtv;

import android.webkit.WebView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


/**
 * Created by Vaironl on 5/15/2016.
 */
public class Livecoding_API {


    private WebView webView;
    private static AsyncHttpClient client = new AsyncHttpClient();


    public static void getLivestreams() {


        client.get("https://www.livecoding.tv:443/api/livestreams/?format=json&access_token=" +
                Login_MainActivity.access_token, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray results = response.getJSONArray("results");


                    for (int index = 0; index < results.length(); index++) {
                        JSONObject user = results.getJSONObject(index);
                        if (user.getBoolean("is_live")) {
//                            System.out.println(user.getString("user__slug"));
                            //Get all of the info into streams

                            String title, username, description, codingCategory, difficulty,
                                    language, viewingURL;
                            boolean islive;
                            int viewCount;

                            title = user.getString("title");
                            username = user.getString("user__slug");
                            description = user.getString("description");
                            codingCategory = user.getString("coding_category");
                            difficulty = user.getString("difficulty");
                            language = user.getString("language");
                            viewingURL = user.getJSONArray("viewing_urls").get(0).toString();
                            viewCount = user.getInt("viewers_live");


                            Tab1.addStream(new Stream(title, username, description,
                                    codingCategory, difficulty,
                                    language, viewingURL, true, viewCount));
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onFinish() {
                Tab1.updateAdapter();
            }
        });

    }

}
