package com.example.nursery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.nursery.application.HomeApplication;
import com.example.nursery.myrecycle.CustomAdapter;
import com.example.nursery.myrecycle.Model;
import com.example.nursery.network.account.AccountService;
import com.example.nursery.network.account.dto.LoginResultDTO;
import com.example.nursery.network.account.dto.ValidationRegisterDTO;
import com.example.nursery.network.animals.AnimalService;
import com.example.nursery.security.JwtSecurityService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecycleActivity extends AppCompatActivity {
    private CustomAdapter customAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        recyclerView = findViewById(R.id.rcv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false));

        AnimalService.getInstance()
                .getJSONApi()
                .getAnimals()
                .enqueue(new Callback<List<Model>>() {
                    @Override
                    public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                        if (response.isSuccessful()) {
                            List<Model> result = response.body();
                            customAdapter = new CustomAdapter(result, recyclerView.getContext());
                            recyclerView.setAdapter(customAdapter);
                            //result.getToken();
                            Log.d("Good Request", result.toString());
                        } else {

                            Log.d("Bad request: ", response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Model>> call, Throwable t) {

                    }
                });

    }
}