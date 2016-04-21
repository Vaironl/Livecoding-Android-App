package dozapps.com.livecodingtv;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

/**
 * Created by vaironl on 4/21/16.
 */
public class Livestreams_Preview extends ActionBarActivity {


    /*
    Must find alternative to ActionBarActivity since it's deprecated
     */

    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence titles[] = {"Livestreams", "Videos", "Playlist"};
    final int numOfTabs = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livestreams_preview);

        toolbar = (Toolbar) findViewById(R.id.toolBar);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), titles, numOfTabs);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);

        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }

        });

        tabs.setViewPager(pager);
    }
}
