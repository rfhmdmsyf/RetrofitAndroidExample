package com.example.retrofitandroidexample.retrofit;

import com.example.retrofitandroidexample.model.Diskon;
import com.example.retrofitandroidexample.model.Diskon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataServices {
    @GET("/Diskon.json")
    public Call<List<Diskon>> getDiskon();
}
