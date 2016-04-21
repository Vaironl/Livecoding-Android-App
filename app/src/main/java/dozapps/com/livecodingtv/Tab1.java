package dozapps.com.livecodingtv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaironl on 4/17/16.
 */
public class Tab1 extends Fragment {

    private ListView livestreamsListView;
    private StreamAdapter adapter;
    private List<Streams> streamList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_1, container, false);


        livestreamsListView = (ListView) view.findViewById(R.id.livestreamsAvailableLV);

        streamList = new ArrayList<>();

        streamList.add(new Streams("Making an Android app", "Vaironl"));
        streamList.add(new Streams("Making a web app", "User 2"));
        streamList.add(new Streams("Unity 3D Game for Lundum Dare", "User 3"));
        streamList.add(new Streams("Testing new programming stuff", "User 4"));

        adapter = new StreamAdapter(view.getContext(), R.layout.livestreams_preview_simple_list_item, streamList);

        livestreamsListView.setAdapter(adapter);


        return view;
    }
}
