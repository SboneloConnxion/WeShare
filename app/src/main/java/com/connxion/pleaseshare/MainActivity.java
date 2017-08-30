package com.connxion.pleaseshare;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


import java.io.File;

import static com.connxion.pleaseshare.R.id.action_share;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApplicationInfo app = getApplicationContext().getApplicationInfo();
                String filePath = app.sourceDir;
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("application/*");
                //String shareBody = "Please share my App with your friends.";
                //String shareSub = "PleaseShare" + ".";
                //share.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                //share.putExtra(Intent.EXTRA_TEXT, shareBody);
                share.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filePath)));
                startActivity(Intent.createChooser(share, "Share with..."));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.action_exit){
            finish();
        }

        else if (id == action_share){
            //Pop up the device's built-in sharing activity
            ApplicationInfo app = getApplicationContext().getApplicationInfo();
            String filePath = app.sourceDir;

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("application/*");

            intent.setPackage("com.android.bluetooth");

            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filePath)));
            startActivity(Intent.createChooser(intent, "Share with..."));
        }

        else if (id == R.id.action_about){
            //Open the "About" activity
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new SendActivity();

                case 1:
                    return new ReceiveActivity();

                case 2:
                    return new HistoryActivity();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SEND";
                case 1:
                    return "RECEIVE";
                case 2:
                    return "HISTORY";
            }
            return null;
        }
    }
}
