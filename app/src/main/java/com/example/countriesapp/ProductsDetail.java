package com.example.countriesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.countriesapp.data.ProductsData;
import com.example.countriesapp.databinding.ActivityProductsDetailBinding;

public class ProductsDetail extends AppCompatActivity {

    ProductsData product;
    ActivityProductsDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_products_detail);

        product = (ProductsData) getIntent().getSerializableExtra("product");

        Glide.with(this).load("http://192.168.169.208/app/images/" + product.getImage()).into(binding.img);
        binding.txtName.setText(product.getName());
        binding.txtPrice.setText(product.getPrice() + " Rs/-");
        binding.txtDescription.setText(product.getDescription());
    }
}