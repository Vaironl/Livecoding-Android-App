package dozapps.com.livecodingtv;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by vaironl on 4/17/16.
 */
public class Livestreams extends FragmentActivity {

    private ViewPager streamsViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.tool_bar);

        final android.app.ActionBar actionBar = getActionBar();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for (int index = 0; index < 3; index++)
        {
            actionBar.newTab().setText("Tab " + (index+1));
        }


    }

    public class StreamsPagerAdapter extends FragmentStatePagerAdapter {

        public StreamsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = new ObjectFragment();
            Bundle arguments = new Bundle();
            arguments.putInt(ObjectFragment.ARG_OBJECT, position + 1);
            fragment.setArguments(arguments);
            return fragment;
        }

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "OBJECT " + (position + 1);
        }
    }


    public static class ObjectFragment extends Fragment {

        public static final String ARG_OBJECT = "object";

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);
            Bundle arguments = getArguments();
            ((TextView) rootView.findViewById(android.R.id.text1)).setText(
                    Integer.toString(arguments.getInt(ARG_OBJECT)));
            return rootView;
        }
    }
}
