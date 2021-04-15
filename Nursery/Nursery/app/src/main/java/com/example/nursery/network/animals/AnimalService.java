package com.example.nursery.network.animals;

import com.example.nursery.constants.Urls;
import com.example.nursery.network.account.AccountApi;
import com.example.nursery.network.account.AccountService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimalService {
    private static AnimalService mInstance;
    private static final String BASE_URL = Urls.BASE_URL;
    private Retrofit retrofit;

    public AnimalService() {
        OkHttpClient.Builder client = new OkHttpClient
                .Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS);
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
    }

    public static AnimalService getInstance() {
        if(mInstance == null)
            mInstance = new AnimalService();
        return mInstance;
    }
    public AnimalApi getJSONApi() {
        return retrofit.create(AnimalApi.class);
    }
}
