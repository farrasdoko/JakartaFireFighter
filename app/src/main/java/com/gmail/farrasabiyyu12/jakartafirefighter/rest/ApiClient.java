package com.gmail.farrasabiyyu12.jakartafirefighter.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL="http://api.jakarta.go.id/";

    private static Retrofit setInit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiInterface getInstance() {
        return setInit().create(ApiInterface.class);
    }
}
