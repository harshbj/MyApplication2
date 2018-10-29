package com.example.hritik.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class homepage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String name;

    FirebaseAuth auth;
    FirebaseUser user;
    public static final String codename = "bundlenameis";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();



        setSelectedoptionscreen(R.id.your_loc);

        Intent myintent = getIntent();
        if(myintent!=null) {
            name = myintent.getStringExtra(InviteCodeActivity.text);
        }



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    private void setSelectedoptionscreen(int itemid)
    {
        Fragment fragment = null;
       Bundle bundle = new Bundle();
       if(name!=null)
        bundle.putString(codename,name);


        switch (itemid)
        {
            case R.id.your_loc:
            {
                fragment = new yourlocation();
                fragment.setArguments(bundle);
                break;
            }
            case R.id.join_cir:
            {
                fragment = new joincircle();
                break;
            }
            case R.id.share_loc:
            {
                fragment = new shareloc();
                break;
            }
            case R.id.about_us:
            {
                fragment = new aboutus();
                break;
            }
            case R.id.friend_list:
            {
                fragment = new friendlist();
                break;
            }
            case R.id.log_out:
            {

                if(user != null)
                {
                    auth.signOut();
                    finish();
                    Intent i  = new Intent(this,main.class);
                    startActivity(i);
                }
            }

        }

        if(fragment != null)
        {
            FragmentTransaction ft  = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.f_1,fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        setSelectedoptionscreen(id);
        return true;
    }
}
