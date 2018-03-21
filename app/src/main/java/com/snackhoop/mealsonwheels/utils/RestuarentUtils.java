package com.snackhoop.mealsonwheels.utils;

import com.snackhoop.mealsonwheels.ShowRestaurentActivity.RestuarentDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aakash Alagarsamy on 3/21/2018.
 */

public class RestuarentUtils {
    public static List<RestuarentDetails> getRestaurentList(List<String> meetingPoints,List<RestuarentDetails> Allrestuarents){
        List<RestuarentDetails> list = new ArrayList<>();
//        meetingPoints = removeDuplicate();
        for (int i=0;i<Allrestuarents.size()-1;i++){
            for (int j=i+1;j<Allrestuarents.size();j++){
//                if (Allrestuarents.get()){
//
//                }
            }
        }
        return list;
    }
    public static List<String> removeDuplicate()
    {
        return null;
    }
}
