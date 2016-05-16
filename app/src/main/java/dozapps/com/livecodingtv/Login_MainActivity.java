package dozapps.com.livecodingtv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class Login_MainActivity extends Activity {


    private WebView webView;
    private String URL = "https://www.livecoding.tv/o/authorize?client_id=" + CLIENT_KEYS.CLIENT_ID +
            "&response_type=token&state=random_state_string";
    public static String access_token = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                access_token = getAccessToken(url);
                if (access_token != null) {

                    Intent liveStreamsIntent = new Intent(Login_MainActivity.this,
                            Livestreams_Preview.class);
                    startActivity(liveStreamsIntent);
                } else {
//                    Toast.makeText(Login_MainActivity.this, "The user did not authorize the " +
//                            "request.", Toast.LENGTH_LONG).show();
                }

                return false;
            }

        });

        webView.loadUrl(URL);
    }

    private String getAccessToken(String URL) {

        String token = null;
        int tokenIndex = URL.indexOf("access_token");

        if (tokenIndex != -1) {
            tokenIndex = URL.indexOf("=",tokenIndex)+1;
            token = URL.substring(tokenIndex, URL.indexOf("&", tokenIndex));
        }

        return token;
    }

}
