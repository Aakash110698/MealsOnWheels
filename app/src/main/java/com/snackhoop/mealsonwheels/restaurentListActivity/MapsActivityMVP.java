package com.snackhoop.mealsonwheels.restaurentListActivity;

/**
 * Created by malavan on 12/03/18.
 */

public interface MapsActivityMVP {
    interface View{

    }
    interface Presenter{
        void setView(MapsActivityMVP.View view);
    }
    interface Model{

    }
}
