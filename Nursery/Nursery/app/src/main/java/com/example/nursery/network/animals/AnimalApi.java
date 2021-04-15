package com.example.nursery.network.animals;

import com.example.nursery.myrecycle.Model;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimalApi {
    @GET("/api/animal/animals")
    public Call<List<Model>> getAnimals();
}
