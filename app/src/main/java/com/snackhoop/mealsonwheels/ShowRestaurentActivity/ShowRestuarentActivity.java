package com.snackhoop.mealsonwheels.ShowRestaurentActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.root.RestuarentDetails;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowRestuarentActivity extends AppCompatActivity implements ShowRestaurentMVP.View{


    @BindView(R.id.recyclerview_listrestaurent)
    RecyclerView recyclerviewListrestaurent;
    List<RestuarentDetails> list = new ArrayList<>();
    ShowRestaurentPresenter presenter;
    @Override
    protected void onResume() {
        super.onResume();
        presenter = new ShowRestaurentPresenter();
        presenter.setView(this);
        presenter.loadData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_restuarent);
        ButterKnife.bind(this);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_name);
        recyclerviewListrestaurent.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        presenter = new ShowRestaurentPresenter();
//        getActionBar().hide();


    }



    @Override
    public void setAdapter(List<RestuarentDetails> details) {
        recyclerviewListrestaurent.setAdapter(new RestuarentAdapter(details,getApplicationContext()));
    }

    @Override
    public void showNetworkError() {
        Toast.makeText(this, "No network found", Toast.LENGTH_SHORT).show();
    }
}
