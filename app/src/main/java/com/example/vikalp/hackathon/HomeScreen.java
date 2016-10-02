package com.example.vikalp.hackathon;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vikalp.hackathon.activity.Compete;
import com.example.vikalp.hackathon.activity.MerchantActivity;
import com.example.vikalp.hackathon.adapter.ViewPagerAdapter;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.LinkedList;
import java.util.List;

public class HomeScreen extends AppCompatActivity {


    private TabLayout smartTabLayout;
    private ViewPagerAdapter adapter;
    private ViewPager viewPager;
    Toolbar toolbar;

    private static String EMAIL_ID;

    private FloatingActionButton actionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        ActionBar actionBar =  getSupportActionBar();
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        actionButton = (FloatingActionButton) findViewById(R.id.test_detail_floating_button);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, Compete.class));
            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        View view = navigationView.inflateHeaderView(R.layout.navigation_header);
        TextView textview = (TextView) view.findViewById(R.id.username);
        textview.setText(getUsername());
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {



                }

                return false;
            }
        });



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
        smartTabLayout = (TabLayout) findViewById(R.id.tabs);

        smartTabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < smartTabLayout.getTabCount(); i++) {
            if(i==0){
                smartTabLayout.getTabAt(i).setIcon(R.drawable.home_tab_icon);
                smartTabLayout.getTabAt(i).getIcon().setColorFilter(Color.parseColor("#FF9800"), PorterDuff.Mode.SRC_IN);

            }else if(i==1){
                smartTabLayout.getTabAt(i).setIcon(R.drawable.alaram_tab_icon);
                smartTabLayout.getTabAt(i).getIcon().setColorFilter(Color.parseColor("#FF9800"), PorterDuff.Mode.SRC_IN);

            }else if(i==2){
                smartTabLayout.getTabAt(i).setIcon(R.drawable.profile_white_icon);
                smartTabLayout.getTabAt(i).getIcon().setColorFilter(Color.parseColor("#FF9800"), PorterDuff.Mode.SRC_IN);
            }
        }

/*
        Button button = (Button) v.get
        button.getBackground().setColorFilter(Color.CYAN, PorterDuff.Mode.MULTIPLY);
*/

        smartTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Drawable icon = tab.getIcon();
                if(tab.getPosition()==0){
                    getSupportActionBar().setTitle("Home");
                }else if(tab.getPosition()==1){
                    getSupportActionBar().setTitle("Updates");
                }else if(tab.getPosition()==2){
                    getSupportActionBar().setTitle("Profile");
                }
                icon.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }





    public String getUsername() {
        AccountManager manager = AccountManager.get(this);
        Account[] accounts = manager.getAccountsByType("com.google");
        List<String> possibleEmails = new LinkedList<String>();

        for (Account account : accounts) {
            // TODO: Check possibleEmail against an email regex or treat
            // account.name as an email address only for certain account.type
            // values.
            possibleEmails.add(account.name);
        }

        if (!possibleEmails.isEmpty() && possibleEmails.get(0) != null) {
            String email = possibleEmails.get(0);
            EMAIL_ID = email;
            String[] parts = email.split("@");
            if (parts.length > 0 && parts[0] != null)
                return parts[0];
            else
                return null;
        } else
            return null;
    }
}
