package com.example.colleges.networkinstance;

import com.example.colleges.models.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface universities_api {

    @GET("search")
    Call<List<model>> getuniversities(@Query("country") String country);
}
