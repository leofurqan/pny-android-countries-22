package com.example.countriesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.countriesapp.databinding.ActivityProductsBinding;
import com.example.countriesapp.fragments.ProductsFragment;

public class ProductsActivity extends AppCompatActivity {

    ActivityProductsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_products);

        loadFragment(new ProductsFragment());
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.layout_frame, fragment).commit();
    }
}