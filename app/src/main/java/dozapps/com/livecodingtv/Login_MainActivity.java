package dozapps.com.livecodingtv;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Login_MainActivity extends ActionBarActivity {

    private Button loginButton;

    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence titles[] = {"Live", "Videos"};
    final int numOfTabs = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        toolbar = (Toolbar) findViewById(R.id.toolBar);

        adapter= new ViewPagerAdapter(getSupportFragmentManager(), titles, numOfTabs);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);

        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            public int getIndicatorColor(int position)
            {
                return getResources().getColor(R.color.tabsScrollColor);
            }

        });

        tabs.setViewPager(pager);



//        loginButton = (Button) findViewById(R.id.userLoginB);
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Start new Activity??
//                Intent streamsIntent = new Intent(Login_MainActivity.this, Livestreams.class);
//                startActivity(streamsIntent);
//            }
//        });
    }

}
