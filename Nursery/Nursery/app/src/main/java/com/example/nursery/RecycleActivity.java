package com.example.nursery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nursery.myrecycle.CustomAdapter;
import com.example.nursery.myrecycle.Model;

import java.util.ArrayList;
import java.util.List;

public class RecycleActivity extends AppCompatActivity {
private CustomAdapter customAdapter;
private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        recyclerView = findViewById(R.id.rcv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false));
        List<Model> list = new ArrayList<>();
        Model model = new Model("Slavik", "22");
        list.add(model);

        customAdapter = new CustomAdapter(list, this);
        recyclerView.setAdapter(customAdapter);
    }
}