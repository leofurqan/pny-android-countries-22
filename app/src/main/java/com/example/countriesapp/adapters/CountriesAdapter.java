package com.example.countriesapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.countriesapp.R;
import com.example.countriesapp.data.CountriesData;

import java.util.ArrayList;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.ViewHolder>{

    Context context;
    private ArrayList<CountriesData> countries;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgCountry;
        private TextView txtName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCountry = itemView.findViewById(R.id.img_country);
            txtName = itemView.findViewById(R.id.txt_country);
        }

        public ImageView getImgCountry() {
            return imgCountry;
        }

        public TextView getTxtName() {
            return txtName;
        }
    }

    public CountriesAdapter(Context c, ArrayList<CountriesData> countries) {
        this.context = c;
        this.countries = countries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_country, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CountriesData data = countries.get(position);
        Glide.with(context).load(data.getFlag()).into(holder.getImgCountry());
        holder.getTxtName().setText(data.getName());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
}
