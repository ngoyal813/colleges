package com.example.colleges.networkinstance;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit_instance {

    public static String BASE_URL = "http://universities.hipolabs.com/";
    private static Retrofit retrofit;

    public static Retrofit getRetroClient()
    {
        if(retrofit == null){

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;

    }
}
