package com.snackhoop.mealsonwheels.homeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.snackhoop.mealsonwheels.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    BottomSheetBehavior bottomSheetBehavior;
    @BindView(R.id.card_bottom_sheet_clicker)
    CardView cardBottomSheetClicker;
    @BindView(R.id.btn_start)
    Button btn_start;
    @BindView(R.id.cardView_Destination)
    CardView destination;
    @BindView(R.id.cardView_Origin)
    CardView origin;
    @BindView(R.id.btn_search)
    Button btn_search;
    @BindView(R.id.destination_textview)
    TextView textView_destination;
    @BindView(R.id.origin_textview)
    TextView textView_origin;
    private final static int PLACE_PICKER_ORIGIN = 1;
    private final static int PLACE_PICKER_DESTINATION = 2;
    private Place origin_place;
    private Place destination_place;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        View bottomsheet = findViewById(R.id.bottomsheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);
        bottomSheetBehavior.setState(4);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
origin.setOnClickListener(this);
destination.setOnClickListener(this);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.home, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @OnClick(R.id.btn_start)
    public void onViewClicked() {
        if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED)
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        else
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_search:

                break;
            case R.id.cardView_Destination:
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(this), PLACE_PICKER_DESTINATION);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.cardView_Origin:
                PlacePicker.IntentBuilder builderOrigin = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builderOrigin.build(this), PLACE_PICKER_ORIGIN);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PLACE_PICKER_DESTINATION) {
            if (resultCode == RESULT_OK) {
                 destination_place = PlacePicker.getPlace(data, getApplicationContext());
                 textView_destination.setText(destination_place.getName());
                Log.d("TAG", "onActivityResult: "+destination_place.getName());
                 //                 textView_destination.setText(destination_place.getName());

            }
        }
        else if (requestCode == PLACE_PICKER_ORIGIN){
            if (resultCode == RESULT_OK){
                origin_place = PlacePicker.getPlace(data,this);
                textView_origin.setText(origin_place.getName());
                Log.d("TAG", "onActivityResult: "+origin_place.getName());
            }
        }

    }
}
