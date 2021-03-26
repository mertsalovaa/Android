package com.example.nursery.network.account;

import android.util.Log;

import com.example.nursery.constants.Urls;

import java.util.concurrent.TimeUnit;

import retrofit2.Retrofit;
import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;

public class AccountService {
    private static AccountService nInstance;
    private static final String BASE_URL = Urls.BASE_URL;
    private Retrofit retrofit;

    public AccountService() {
        try {
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
        catch (Exception ex) {
            Log.d("vbbf", ex.getMessage());
        }
    }

    public static AccountService getInstance() {
        if (nInstance == null)
        {
            nInstance = new AccountService();
        }
        return nInstance;
    }

    public AccountApi getJSONApi() {
        return retrofit.create(AccountApi.class);
    }
}