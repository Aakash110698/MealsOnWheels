package com.snackhoop.mealsonwheels.ShowRestaurentActivity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by malavan on 12/03/18.
 */

public class RestuarentAdapter extends RecyclerView.Adapter<RestuarentAdapter.RestaurentViewHolder> {



    @Override
    public RestaurentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RestaurentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RestaurentViewHolder extends RecyclerView.ViewHolder{

        public RestaurentViewHolder(View itemView) {
            super(itemView);
        }
    }
}

