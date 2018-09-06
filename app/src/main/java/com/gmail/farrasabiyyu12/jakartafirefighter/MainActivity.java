package com.gmail.farrasabiyyu12.jakartafirefighter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.gmail.farrasabiyyu12.jakartafirefighter.Adapter.MyAdapter;
import com.gmail.farrasabiyyu12.jakartafirefighter.model.DataItem;
import com.gmail.farrasabiyyu12.jakartafirefighter.model.ResponsePetugas;
import com.gmail.farrasabiyyu12.jakartafirefighter.rest.ApiClient;
import com.gmail.farrasabiyyu12.jakartafirefighter.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recy_petugas;
    ApiInterface mApiInterface = ApiClient.getInstance();
    MyAdapter adapter;
    String token = "5O6W5d5iujdM6evlmtyo5F0r64XrG9h7iCqmYvVjqkEIJn2N4ZcM8cYKOKGjsckS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recy_petugas = findViewById(R.id.recy_petugas);
        getData();
    }

    private void getData() {
        Call<ResponsePetugas> petugasCall = mApiInterface.getPetugas(token);
        petugasCall.enqueue(new Callback<ResponsePetugas>() {
            @Override
            public void onResponse(Call<ResponsePetugas> call, Response<ResponsePetugas> response) {
                String status = response.body().getStatus();
                if (status.equals("success")) {
                    recy_petugas.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    List<DataItem> petugasList = response.body().getData();
                    Log.d("Retrofit Get", "Jumlah Pegawai Pemadam Kebakaran: " + String.valueOf(petugasList.size()));
                    adapter = new MyAdapter(petugasList, MainActivity.this);
                    recy_petugas.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponsePetugas> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
