package dozapps.com.livecodingtv.Stream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import cz.msebera.android.httpclient.Header;

/**
 * Created by vaironl on 4/21/16.
 */
public class Stream {

    private String username, title, description, codingCategory, difficulty,
            language, viewingURL, thumbnailURL;
    boolean live;
    private int viewCount;


    private Bitmap thumbnail;

    public Stream() {
        username = "NULLOBJECT";
        title = "NULLOBJECT";
        description = "NULLOBJECT";
        codingCategory = "NULLOBJECT";
        difficulty = "NULLOBJECT";
        language = "NULLOBJECT";
        viewingURL = "NULLOBJECT";
        thumbnailURL = "NULLOBJECT";
        live = false;
        viewCount = 0;
        thumbnail = null;
    }

    public Stream(String title, String username, String description, String codingCategory,
                  String difficulty, String language, String viewingURL, boolean live, int
                          viewCount, String thumbnailURL) {

        this.title = title;
        this.username = username;
        this.description = description;
        this.codingCategory = codingCategory;
        this.difficulty = difficulty;
        this.language = language;
        this.viewingURL = viewingURL;
        this.live = live;
        this.viewCount = viewCount;
        this.thumbnailURL = thumbnailURL;

        downloadImage(this.thumbnailURL, new BitmapCallack() {
            @Override
            public void bitmapResponse(Bitmap source) {
                thumbnail = source;
            }
        });

    }


    public interface BitmapCallack {
        public void bitmapResponse(Bitmap source);
    }

    private void downloadImage(String URL, final BitmapCallack callback) {


        AsyncHttpClient client = new AsyncHttpClient();

        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                callback.bitmapResponse(BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length));

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodingCategory() {
        return codingCategory;
    }

    public void setCodingCategory(String codingCategory) {
        this.codingCategory = codingCategory;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getViewingURL() {
        return viewingURL;
    }

    public void setViewingURL(String viewingURL) {
        this.viewingURL = viewingURL;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Bitmap getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Bitmap thumbnail) {
        this.thumbnail = thumbnail;
    }
}
