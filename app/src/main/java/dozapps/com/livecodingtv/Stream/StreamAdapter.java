package dozapps.com.livecodingtv.Stream;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dozapps.com.livecodingtv.R;

/**
 * Created by vaironl on 4/21/16.
 */
public class StreamAdapter extends ArrayAdapter {
    public StreamAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }



    private static class StreamHolder {
        private ImageView streamPreviewImage;
        private TextView streamUsername;
        private TextView streamTitle;
        private TextView streamViewCount;
        private TextView streamLanguage;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        StreamHolder streamHolder = null;
        if (row == null) {

            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            row = inflater.inflate(R.layout.livestreams_preview_simple_list_item, parent, false);

            streamHolder = new StreamHolder();

            streamHolder.streamPreviewImage = (ImageView) row.findViewById(R.id.streamImagePreview);
            streamHolder.streamUsername = (TextView) row.findViewById(R.id.streamUsername);
            streamHolder.streamTitle = (TextView) row.findViewById(R.id.streamTitle);
            streamHolder.streamViewCount = (TextView) row.findViewById(R.id.streamViewCount);
            streamHolder.streamLanguage = (TextView) row.findViewById(R.id.streamLanguage);

            row.setTag(streamHolder);

        } else {
            streamHolder = (StreamHolder) row.getTag();
        }

        Stream currentStream = (Stream) this.getItem(position);

        streamHolder.streamPreviewImage.setImageBitmap(currentStream.getThumbnail());
        streamHolder.streamUsername.setText(currentStream.getUsername());
        streamHolder.streamTitle.setText(currentStream.getTitle());
        streamHolder.streamViewCount.setText(String.valueOf(currentStream.getViewCount()));
        streamHolder.streamLanguage.setText(currentStream.getCodingCategory());


        return row;
    }
}
