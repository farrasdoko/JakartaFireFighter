package com.gmail.farrasabiyyu12.jakartafirefighter.Adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.farrasabiyyu12.jakartafirefighter.DetailActivity;
import com.gmail.farrasabiyyu12.jakartafirefighter.MainActivity;
import com.gmail.farrasabiyyu12.jakartafirefighter.R;
import com.gmail.farrasabiyyu12.jakartafirefighter.model.DataItem;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<DataItem> dataItems;
    Context context;

    public MyAdapter(List<DataItem> dataItemsct, Context contextct) {
        dataItems = dataItemsct;
        context = contextct;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(mView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
        myViewHolder.tv_nama.setText(dataItems.get(i).getNama());
        myViewHolder.tv_phone.setText(dataItems.get(i).getPhone());
        myViewHolder.tv_wilayah.setText(dataItems.get(i).getWilayah());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity( new Intent(context, DetailActivity.class)
                        .putExtra("nama", dataItems.get(i).getNama())
                        .putExtra("phone", dataItems.get(i).getPhone())
                        .putExtra("wilayah", dataItems.get(i).getWilayah())
                        .putExtra("alamat", dataItems.get(i).getAlamat())
                        .putExtra("jabatan", dataItems.get(i).getJabatan())
                        .putExtra("login", dataItems.get(i).getLoginTerakhir()));

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_nama, tv_wilayah, tv_phone;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_nama = itemView.findViewById(R.id.tv_nama);
            tv_wilayah = itemView.findViewById(R.id.tv_wilayah);
            tv_phone = itemView.findViewById(R.id.tv_phone);
        }
    }
}
