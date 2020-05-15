package com.example.learn_it;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<DataModel> data = getListData();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        RecyclerAdapter adapter = new RecyclerAdapter(data);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(itemAnimator);
    }

    private List<DataModel> getListData() {
        List<DataModel> data = new ArrayList<>();

        data.add(new DataModel(getString(R.string.lm), getString(R.string.lm_desc), R.drawable.icon01));
        data.add(new DataModel(getString(R.string.uam), getString(R.string.uam_desc), R.drawable.icon02));
        data.add(new DataModel(getString(R.string.pm), getString(R.string.pm_desc), R.drawable.icon03));
        data.add(new DataModel(getString(R.string.ccm), getString(R.string.ccm_desc), R.drawable.icon04));
        data.add(new DataModel(getString(R.string.f), getString(R.string.f_desc), R.drawable.icon05));
        data.add(new DataModel(getString(R.string.pwe), getString(R.string.pwe_desc), R.drawable.icon06));

        return data;
    }
}
