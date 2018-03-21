package com.snackhoop.mealsonwheels.ShowRestaurentActivity;

import com.snackhoop.mealsonwheels.root.RestuarentDetails;

import java.util.List;

/**
 * Created by Aakash Alagarsamy on 3/21/2018.
 */

public interface ShowRestaurentMVP {
    interface View{
        void setAdapter(List<RestuarentDetails> details);
        void showNetworkError();

    }
    interface Presenter{
        void setView(ShowRestaurentMVP.View view);
        void loadData();
    }

}
