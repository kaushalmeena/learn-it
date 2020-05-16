package com.example.learn_it;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
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

        RecyclerAdapter adapter = new RecyclerAdapter(data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private List<DataModel> getListData() {
        List<DataModel> data = new ArrayList<>();

        DataModel item1 = new DataModel(getString(R.string.lm), getString(R.string.lm_desc), R.drawable.icon01);
        DataModel item2 = new DataModel(getString(R.string.uam), getString(R.string.uam_desc), R.drawable.icon02);
        DataModel item3 = new DataModel(getString(R.string.pm), getString(R.string.pm_desc), R.drawable.icon03);
        DataModel item4 = new DataModel(getString(R.string.ccm), getString(R.string.ccm_desc), R.drawable.icon04);
        DataModel item5 = new DataModel(getString(R.string.f), getString(R.string.f_desc), R.drawable.icon05);
        DataModel item6 = new DataModel(getString(R.string.pwe), getString(R.string.pwe_desc), R.drawable.icon06);

        data.add(item1);
        data.add(item2);
        data.add(item3);
        data.add(item4);
        data.add(item5);
        data.add(item6);

        return data;
    }
}
