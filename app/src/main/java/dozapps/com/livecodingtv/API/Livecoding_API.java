package dozapps.com.livecodingtv.API;

import android.webkit.WebView;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import dozapps.com.livecodingtv.Login_MainActivity;
import dozapps.com.livecodingtv.Stream.Stream;
import dozapps.com.livecodingtv.Tabs.Tab1;
import dozapps.com.livecodingtv.Tabs.Tab2;


/**
 * Created by Vaironl on 5/15/2016.
 */
public class Livecoding_API {


    private WebView webView;
    private static AsyncHttpClient client = new AsyncHttpClient();


    public static void getVideos() {


        client.get("https://www.livecoding.tv/api/videos/?format=json&access_token=" +
                Login_MainActivity.access_token, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {

                    JSONArray results = response.getJSONArray("results");

                    //REMOVE LENGTH LIMITER IN FOR LOOPresults.length()
                    for (int index = 0; index < results.length(); index++) {
                        JSONObject user = results.getJSONObject(index);

                        //Get all of the info into streams
                        String title, username, description, codingCategory, difficulty,
                                language, viewingURL, thumbnailURL;
                        int viewCount;
                        boolean isLive;

                        title = user.getString("title");
                        username = "SLUG";
                        description = user.getString("description");
                        codingCategory = user.getString("coding_category");
                        difficulty = user.getString("difficulty");
                        language = user.getString("language");
                        viewingURL = user.getJSONArray("viewing_urls").get(0).toString();
                        viewCount = user.getInt("viewers_overall");
                        thumbnailURL = user.getString("thumbnail_url");

                        System.out.println("VIDEO: " + title);


                        Tab2.addVideo(new Stream(title, username, description,
                                codingCategory, difficulty,
                                language, viewingURL, false, viewCount, thumbnailURL));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFinish() {
                Tab2.updateAdapter();
            }
        });
    }


    public static void getLivestreams() {


        client.get("https://www.livecoding.tv/api/livestreams/onair/?format=json&access_token=" +
                Login_MainActivity.access_token, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONArray results = response.getJSONArray("results");


                    for (int index = 0; index < results.length(); index++) {
                        JSONObject user = results.getJSONObject(index);
                        if (user.getBoolean("is_live")) {
//                            System.out.println(user.getString("user__slug"));
                            //Get all of the info into streams

                            String title, username, description, codingCategory, difficulty,
                                    language, viewingURL, thumbnailURL;
                            int viewCount;

                            title = user.getString("title");
                            username = user.getString("user__slug");
                            description = user.getString("description");
                            codingCategory = user.getString("coding_category");
                            difficulty = user.getString("difficulty");
                            language = user.getString("language");
                            viewingURL = user.getJSONArray("viewing_urls").get(2).toString();
                            viewCount = user.getInt("viewers_live");
                            thumbnailURL = user.getString("thumbnail_url");


                            Tab1.addStream(new Stream(title, username, description,
                                    codingCategory, difficulty,
                                    language, viewingURL, true, viewCount, thumbnailURL));
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
