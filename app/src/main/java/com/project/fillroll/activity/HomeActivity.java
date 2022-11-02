package com.project.fillroll.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.project.fillroll.R;
import com.project.fillroll.fragment.HelpFragment;
import com.project.fillroll.fragment.HomeFragment;
import com.project.fillroll.viewpager.ViewPagerAdapter;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {
    private Context context;
    private int user_id;
    ActionBarDrawerToggle mToggle;
    NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    MenuItem prevMenuItem;
    private CircleImageView profileImageView;
    String user_name = "", email = "", phone = "";
    Dialog ConfirmationDialog;
    private Bitmap bits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = HomeActivity.this;
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



        viewPager = (ViewPager) findViewById(R.id.viewpager);


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        setViewPagerItem(0);
                        break;
                    case R.id.navigation_help:
                        setViewPagerItem(1);
                        break;
                }
                return false;
            }
        });
        setupViewPager();


    }

    private void setViewPagerItem(int i) {
        viewPager.setCurrentItem(i);
        if (prevMenuItem != null) {
            prevMenuItem.setChecked(false);
        } else {
            bottomNavigationView.getMenu().getItem(i).setChecked(false);
        }
        Log.d("page", "onPageSelected: " + i);
        bottomNavigationView.getMenu().getItem(i).setChecked(true);
        prevMenuItem = bottomNavigationView.getMenu().getItem(i);
    }


    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //Set fragments
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new HelpFragment());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
    }

}