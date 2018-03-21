package com.snackhoop.mealsonwheels.ShowRestaurentActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.snackhoop.mealsonwheels.root.RestuarentDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aakash Alagarsamy on 3/21/2018.
 */

public class ShowRestaurentPresenter implements ShowRestaurentMVP.Presenter {

    ShowRestaurentMVP.View view;
    private List<RestuarentDetails> list = new ArrayList<>();

    @Override
    public void setView(ShowRestaurentMVP.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("RestaurentList");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    list.add(postSnapshot.getValue(RestuarentDetails.class));
                    view.setAdapter(list);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
