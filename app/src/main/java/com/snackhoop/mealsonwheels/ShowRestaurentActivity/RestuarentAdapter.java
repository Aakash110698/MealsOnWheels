package com.snackhoop.mealsonwheels.ShowRestaurentActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.root.RestuarentDetails;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by malavan on 12/03/18.
 */

public class RestuarentAdapter extends RecyclerView.Adapter<RestuarentAdapter.RestaurentViewHolder> {

    List<RestuarentDetails> restuarentDetails = new ArrayList<>();
    Context context;

    public RestuarentAdapter(List<RestuarentDetails> restuarentDetails,Context context) {
        this.restuarentDetails = restuarentDetails;
        this.context = context;
    }

    @Override
    public RestaurentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RestaurentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_restaurent_card, parent, false));
    }

    @Override
    public void onBindViewHolder(RestaurentViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(RestaurentViewHolder holder, int position, List<Object> payloads) {
        holder.loadData(restuarentDetails.get(position),context);
    }

    @Override
    public int getItemCount() {
        return restuarentDetails.size();
    }

    public class RestaurentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_res_rating)
        TextView tvResRating;
        @BindView(R.id.tv_res_name)
        TextView tvResName;
        @BindView(R.id.tv_res_location)
        TextView tvResLocation;
        @BindView(R.id.iv_res_type)
        ImageView ivResType;
        @BindView(R.id.tv_res_status)
        TextView tvResStatus;
        @BindView(R.id.tv_res_status_time)
        TextView tvResStatusTime;
        @BindView(R.id.tv_res_defn)
        TextView tvResDefn;
        @BindView(R.id.res_img)
        RelativeLayout rlResImg;
        public RestaurentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        public void loadData(RestuarentDetails details,Context context){
            tvResDefn.setText(details.getDescription());
            tvResStatus.setText("Opens at "+details.getOpeningTime());
            tvResLocation.setText(details.getAddress().split(",")[1]);
            tvResRating.setText(details.getRating()+"");
            tvResName.setText(details.getName());
            tvResStatusTime.setText("Opens At "+details.getClosingTime());

            Glide.with(context).load(details.getPhotourl().get(0).getUrl()).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        rlResImg.setBackground(resource);
                    }
                }
            });


        }
    }
}

