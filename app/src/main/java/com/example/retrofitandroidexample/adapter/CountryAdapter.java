package com.example.retrofitandroidexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitandroidexample.R;
import com.example.retrofitandroidexample.model.Diskon;
import com.example.retrofitandroidexample.model.Diskon;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CustomViewHolder> {
    private List<Diskon> dataDiskon;
    private Context context;

    public CountryAdapter(List<Diskon> dataDiskon, Context context) {
        this.dataDiskon = dataDiskon;
        this.context =context;
    }


    @NonNull
    @Override
    public CountryAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_item, parent, false);
        return new CustomViewHolder(view);
    }
//mengakses komponen layout
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.txtdiskonName.setText(dataDiskon.get(position).getDiskonName());

    }
//    mendapatkan jumlah array

    @Override
    public int getItemCount() {
        return dataDiskon.size();
    }
//    melakukan proses binding terhadap komponen layout

    public class CustomViewHolder extends RecyclerView.ViewHolder {
       public final  View mView;

       TextView  txtdiskonName;

       CustomViewHolder(View itemView) {
           super(itemView);
           mView = itemView;


           txtdiskonName = mView.findViewById(R.id.txt_diskon);
       }
    }
}
