package dozapps.com.livecodingtv.Tabs;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import dozapps.com.livecodingtv.API.Livecoding_API;
import dozapps.com.livecodingtv.R;
import dozapps.com.livecodingtv.Stream.Stream;
import dozapps.com.livecodingtv.Stream.StreamAdapter;
import dozapps.com.livecodingtv.VideoPlayer.VideoPlayer;

/**
 * Created by vaironl on 4/17/16.
 */
public class Tab1 extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private ListView livestreamsListView;
    private static StreamAdapter adapter;
    private static List<Stream> streamList;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_1, container, false);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id
                .swipeRefreshLivestreamLayout);
        swipeRefreshLayout.setOnRefreshListener(this);


        livestreamsListView = (ListView) view.findViewById(R.id.livestreamsAvailableLV);

        streamList = new ArrayList<>();

        adapter = new StreamAdapter(view.getContext(), R.layout
                .livestreams_preview_simple_list_item, streamList);

        livestreamsListView.setAdapter(adapter);

        livestreamsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent videoPlayerIntent = new Intent(Tab1.this.getActivity(), VideoPlayer.class);
                videoPlayerIntent.putExtra("videoURL", streamList.get(position).getViewingURL());
                videoPlayerIntent.putExtra("media", 5);
                startActivity(videoPlayerIntent);
            }
        });

        Livecoding_API.getLivestreams();


        return view;
    }

    public static void addStream(Stream stream) {
        streamList.add(stream);

    }


    public static  void updateAdapter() {
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                updateAdapter();
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 300);

    }
}
