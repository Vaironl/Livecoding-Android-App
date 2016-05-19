package dozapps.com.livecodingtv.VideoPlayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import dozapps.com.livecodingtv.R;

import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.EMVideoView;




/**
 * Created by Vaironl on 5/15/2016.
 */
public class VideoPlayer extends Activity implements OnPreparedListener {


    private EMVideoView videoView;

    private void setupVideoView(String URL)
    {

        videoView = (EMVideoView)findViewById(R.id.video_view);
        videoView.setOnPreparedListener(this);
        videoView.setVideoURI(Uri.parse(URL));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.videoplayer);


        String tParameter = "?t=55953FB8BDB7430698C438E21DB505CE";
        String LINK = getIntent().getExtras().getString("videoURL") + tParameter;

        Toast.makeText(this, "LINK: " + LINK, Toast.LENGTH_LONG).show();

        setupVideoView(LINK);


    }

    @Override
    public void onPrepared() {

        videoView.start();

    }
}