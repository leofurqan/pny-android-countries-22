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
import com.example.countriesapp.ProductsDetail;
import com.example.countriesapp.R;
import com.example.countriesapp.data.ProductsData;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private ArrayList<ProductsData> products;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView name, price;
        MaterialCardView cardProduct;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.txt_name);
            price = itemView.findViewById(R.id.txt_price);
            cardProduct = itemView.findViewById(R.id.card_product);
        }

        public ImageView getImg() {
            return img;
        }

        public TextView getName() {
            return name;
        }

        public TextView getPrice() {
            return price;
        }

        public MaterialCardView getCardProduct() {
            return cardProduct;
        }
    }

    public ProductsAdapter(ArrayList<ProductsData> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductsData product = products.get(position);

        Glide.with(context).load("http://192.168.169.208/app/images/" + product.getImage()).into(holder.getImg());
        holder.getName().setText(product.getName());
        holder.getPrice().setText(product.getPrice() + " Rs/-");

        holder.getCardProduct().setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductsDetail.class);
            intent.putExtra("product", product);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


}
