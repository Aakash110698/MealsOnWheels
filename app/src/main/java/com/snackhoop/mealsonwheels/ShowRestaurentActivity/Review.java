
package com.snackhoop.mealsonwheels.ShowRestaurentActivity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("photo_url")
    @Expose
    private String photoUrl;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("uid")
    @Expose
    private String uid;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
