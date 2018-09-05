package com.gmail.farrasabiyyu12.jakartafirefighter.rest;

import com.gmail.farrasabiyyu12.jakartafirefighter.model.ResponsePetugas;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiInterface {

    @GET("v1/emergency/petugaspemadam")
    Call<ResponsePetugas> getPetugas(
            @Header("Authorization")
            String authorization
    );
}
