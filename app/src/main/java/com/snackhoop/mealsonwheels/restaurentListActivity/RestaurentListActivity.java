package com.snackhoop.mealsonwheels.restaurentListActivity;

import android.content.Intent;
import android.graphics.Color;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.ShowRestaurentActivity.RestuarentDetails;
import com.snackhoop.mealsonwheels.ShowRestaurentActivity.ShowRestuarentActivity;
import com.snackhoop.mealsonwheels.root.GoogleMapDirectionData;
import com.snackhoop.mealsonwheels.root.OverviewPolyline;
import com.snackhoop.mealsonwheels.root.PlaceIdIntent;
import com.snackhoop.mealsonwheels.root.Step;
import com.snackhoop.mealsonwheels.utils.RestuarentUtils;
import com.snackhoop.mealsonwheels.webservices.ApiClient;
import com.snackhoop.mealsonwheels.webservices.ApiInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.QueryMap;

public class RestaurentListActivity extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener{

    private GoogleMap mMap;
    private PlaceIdIntent placeIdIntent;
    private OverviewPolyline mOverviewPolyLine;
    @BindView(R.id.listofrestaurent)
    FloatingActionButton listofrestaurent;
    List<String>  areaList=new ArrayList<>();
    List<RestuarentDetails> allRestaurent = new ArrayList<>();
    Geocoder geocoder;
    private final static String TAG="RestuarentListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurent_list);
        ButterKnife.bind(this);
        listofrestaurent.setOnClickListener(this);
        //Initializing
        geocoder = new Geocoder(getApplicationContext());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        SupportMapFragment mapFragment =(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        placeIdIntent = getIntent().getParcelableExtra(getString(R.string.placeidintent));

    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Map<String,String> query = new HashMap<>();
        query.put("origin","place_id:"+placeIdIntent.getOrigin());
        query.put("destination","place_id:"+placeIdIntent.getDestination());
        query.put("key","AIzaSyDR4Npn-9fC7wE0P2js99hn9neh2N3qs08");
        final Call<GoogleMapDirectionData> directionData = apiService.getRoute(query);
        directionData.enqueue(new Callback<GoogleMapDirectionData>() {
            @Override
            public void onResponse(Call<GoogleMapDirectionData> call, Response<GoogleMapDirectionData> response) {
                GoogleMapDirectionData directionData1 = response.body();
                mOverviewPolyLine = response.body().getRoutes().get(0).getOverviewPolyline();
                List<LatLng> mLatLngList = decodePoly(mOverviewPolyLine.getPoints());
                Log.d("TAG", "onResponse: "+mLatLngList.size());
//                LatLng latLng = new LatLng(directionData1.getRoutes().get(0).getLegs().get(0).getStartLocation(),directionData1.;
                List<Step> step = directionData1.getRoutes().get(0).getLegs().get(0).getSteps();


                PolylineOptions options = new PolylineOptions().width(12).color(Color.BLUE).geodesic(true);
                for (int z = 0; z < mLatLngList.size(); z++) {
                    if (z%20==0){
                        try {


                            areaList.add(geocoder.getFromLocation(mLatLngList.get(z).latitude, mLatLngList.get(z).longitude, 1).get(0).getSubLocality());
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    LatLng point = mLatLngList.get(z);
                    options.add(point);
                }
                Polyline line = mMap.addPolyline(options);
                line.setClickable(true);
                line.setTag("Total Distance");
                line.setClickable(true);
                line = googleMap.addPolyline(options);





            }

            @Override
            public void onFailure(Call<GoogleMapDirectionData> call, Throwable t) {

            }
        });

    }

    public void loadPath(){


    }
    private synchronized List<LatLng> decodePoly(String encoded) {

        List<LatLng> poly = new ArrayList<>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;

            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng((((double) lat / 1E5)),
                    (((double) lng / 1E5)));
            poly.add(p);
        }

        return poly;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            super.onBackPressed();
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() ==R.id.listofrestaurent){
            startActivity(new Intent(this,ShowRestuarentActivity.class));
        }
    }




    //AsyncTask to compute restuarent List
    private class ComputeRestuarent extends AsyncTask<List<String>,Integer,List<RestuarentDetails>>{

        @Override
        protected List<RestuarentDetails> doInBackground(List<String>[] lists) {

            ApiInterface apiClient = ApiClient.getClient().create(ApiInterface.class);
            Call<List<RestuarentDetails>> call = apiClient.getAllRestaurent();
            call.enqueue(new Callback<List<RestuarentDetails>>() {
                @Override
                public void onResponse(Call<List<RestuarentDetails>> call, Response<List<RestuarentDetails>> response) {
                    allRestaurent = response.body();
                    Log.d(TAG, "onResponse: "+allRestaurent.size()+"");

                }

                @Override
                public void onFailure(Call<List<RestuarentDetails>> call, Throwable t) {

                }
            });
            return returnResult();
        }
        public List<RestuarentDetails> returnResult(){
          return   allRestaurent;
        }
    }
}
