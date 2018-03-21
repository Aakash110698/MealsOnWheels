
package com.snackhoop.mealsonwheels.root;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestuarentDetails {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("closing_time")
    @Expose
    private String closing_time;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("mobileno")
    @Expose
    private String mobileno;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("opening_hours")
    @Expose
    private OpeningHours opening_hours;
    @SerializedName("opening_time")
    @Expose
    private String opening_time;
    @SerializedName("photourl")
    @Expose
    private List<Photourl> photourl = null;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("rating_overall")
    @Expose
    private RatingOverall rating_overall;
    @SerializedName("review")
    @Expose
    private List<Review> review = null;
    @SerializedName("uid")
    @Expose
    private String uid;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getClosingTime() {
        return closing_time;
    }

    public void setClosingTime(String closingTime) {
        this.closing_time = closingTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getClosing_time() {
        return closing_time;
    }

    public void setClosing_time(String closing_time) {
        this.closing_time = closing_time;
    }

    public OpeningHours getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(OpeningHours opening_hours) {
        this.opening_hours = opening_hours;
    }

    public String getOpening_time() {
        return opening_time;
    }

    public void setOpening_time(String opening_time) {
        this.opening_time = opening_time;
    }

    public RatingOverall getRating_overall() {
        return rating_overall;
    }

    public void setRating_overall(RatingOverall rating_overall) {
        this.rating_overall = rating_overall;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OpeningHours getOpeningHours() {
        return opening_hours;
    }

    public void setOpeningHours(OpeningHours openingHours) {
        this.opening_hours = openingHours;
    }

    public String getOpeningTime() {
        return opening_time;
    }

    public void setOpeningTime(String openingTime) {
        this.opening_time = openingTime;
    }

    public List<Photourl> getPhotourl() {
        return photourl;
    }

    public void setPhotourl(List<Photourl> photourl) {
        this.photourl = photourl;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public RatingOverall getRatingOverall() {
        return rating_overall;
    }

    public void setRatingOverall(RatingOverall ratingOverall) {
        this.rating_overall = ratingOverall;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
