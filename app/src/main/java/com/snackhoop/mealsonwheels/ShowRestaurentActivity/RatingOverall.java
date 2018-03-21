
package com.snackhoop.mealsonwheels.ShowRestaurentActivity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatingOverall {

    @SerializedName("food")
    @Expose
    private Integer food;
    @SerializedName("look_and_feel")
    @Expose
    private Integer lookAndFeel;
    @SerializedName("service")
    @Expose
    private Integer service;

    public Integer getFood() {
        return food;
    }

    public void setFood(Integer food) {
        this.food = food;
    }

    public Integer getLookAndFeel() {
        return lookAndFeel;
    }

    public void setLookAndFeel(Integer lookAndFeel) {
        this.lookAndFeel = lookAndFeel;
    }

    public Integer getService() {
        return service;
    }

    public void setService(Integer service) {
        this.service = service;
    }

}
