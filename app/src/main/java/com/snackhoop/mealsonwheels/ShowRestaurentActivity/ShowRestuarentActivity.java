package com.snackhoop.mealsonwheels.ShowRestaurentActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.snackhoop.mealsonwheels.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowRestuarentActivity extends AppCompatActivity {


    @BindView(R.id.recyclerview_listrestaurent)
    RecyclerView recyclerviewListrestaurent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_restuarent);
        ButterKnife.bind(this);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_name);
    }
}
