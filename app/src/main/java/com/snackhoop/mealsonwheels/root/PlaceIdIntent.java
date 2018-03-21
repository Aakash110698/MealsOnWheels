package com.snackhoop.mealsonwheels.root;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by malavan on 12/03/18.
 */

public class PlaceIdIntent implements Parcelable{
    String origin;
    String destination;

    public PlaceIdIntent(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    protected PlaceIdIntent(Parcel in) {
        origin = in.readString();
        destination = in.readString();
    }

    public static final Creator<PlaceIdIntent> CREATOR = new Creator<PlaceIdIntent>() {
        @Override
        public PlaceIdIntent createFromParcel(Parcel in) {
            return new PlaceIdIntent(in);
        }

        @Override
        public PlaceIdIntent[] newArray(int size) {
            return new PlaceIdIntent[size];
        }
    };

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(origin);
        parcel.writeString(destination);
    }

}
