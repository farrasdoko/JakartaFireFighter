package com.gmail.farrasabiyyu12.jakartafirefighter.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.farrasabiyyu12.jakartafirefighter.R;
import com.gmail.farrasabiyyu12.jakartafirefighter.model.DataItem;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

//    Context context;
    List<DataItem> dataItems;

    public MyAdapter(List<DataItem> dataItemsct) {
        dataItems = dataItemsct;
//        context = contextct;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(mView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_nama.setText(dataItems.get(i).getNama());
        myViewHolder.tv_phone.setText(dataItems.get(i).getPhone());
        myViewHolder.tv_wilayah.setText(dataItems.get(i).getWilayah());
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
