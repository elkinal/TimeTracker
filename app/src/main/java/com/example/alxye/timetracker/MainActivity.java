package com.example.alxye.timetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        initToolbar();
        initNavigationView();
        initBottomNavigationView();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initNavigationView() {
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.activity_main_drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.activity_main_drawer_layout_open,R.string.activity_main_drawer_layout_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.activity_main_navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                int id = item.getItemId();
                switch (id) {
                    case R.id.menu_navigation_view_help:
                        Intent intent1 = new Intent(MainActivity.this,HelpActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.menu_navigation_view_feedback:
                        Intent intent2 = new Intent(MainActivity.this,FeedBackActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.menu_navigation_view_settings:
                        Intent intent3 = new Intent(MainActivity.this,SettingsActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.menu_navigation_view_assess:
                        Intent intent4 = new Intent(MainActivity.this,AssessActivity.class);
                        startActivity(intent4);
                        break;
                    case R.id.menu_navigation_view_about:
                        Intent intent5 = new Intent(MainActivity.this,AboutActivity.class);
                        startActivity(intent5);
                }
                return true;
            }
        });
    }

    private void initBottomNavigationView() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.activity_main_bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.navigation_home:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_dashboard:
                        Toast.makeText(MainActivity.this, "Dashboard", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_notifications:
                        Toast.makeText(MainActivity.this, "Notifications", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

}
