package com.snackhoop.mealsonwheels.webservices;

import com.snackhoop.mealsonwheels.ShowRestaurentActivity.RestuarentDetails;
import com.snackhoop.mealsonwheels.root.GoogleMapDirectionData;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by malavan on 10/03/18.
 */

public interface ApiInterface {
    // @GET()
   //Call<Object> getRoute(@QueryMap Map<String,Object> map);
    @GET("json")
    Call<GoogleMapDirectionData> getRoute(@QueryMap Map<String,String> map);
    @GET("RestaurentList/json")
    Call<List<RestuarentDetails>> getAllRestaurent();

}
