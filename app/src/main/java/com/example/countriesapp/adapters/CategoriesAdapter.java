package com.example.countriesapp.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countriesapp.R;
import com.example.countriesapp.data.CategoriesData;
import com.example.countriesapp.data.ProductsData;
import com.example.countriesapp.interfaces.ClickListener;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private ArrayList<CategoriesData> categories;
    private Context context;

    ClickListener clickListener;

    public void setOnClickListener(ClickListener listener) {
        this.clickListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private MaterialCardView cardCategory;
        private TextView txtName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardCategory = itemView.findViewById(R.id.card_category);
            txtName = itemView.findViewById(R.id.txt_name);
        }

        public MaterialCardView getCardCategory() {
            return cardCategory;
        }

        public TextView getTxtName() {
            return txtName;
        }
    }

    public CategoriesAdapter(ArrayList<CategoriesData> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoriesData category = categories.get(position);
        holder.txtName.setText(category.getName());

        if(category.isSelected()) {
            holder.getCardCategory().setCardBackgroundColor(Color.parseColor("#48d861"));
            holder.getTxtName().setTextColor(Color.parseColor("#ffffff"));
            holder.getCardCategory().setStrokeWidth(0);
        } else {
            holder.getCardCategory().setCardBackgroundColor(Color.parseColor("#ffffff"));
            holder.getTxtName().setTextColor(Color.parseColor("#000000"));
            holder.getCardCategory().setStrokeWidth(2);
        }

        holder.getCardCategory().setOnClickListener(v -> {
            clickListener.onCategoryClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


}
