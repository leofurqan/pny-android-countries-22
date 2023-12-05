package com.example.countriesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.countriesapp.data.CountriesData;
import com.example.countriesapp.databinding.ActivityCountryDetailBinding;

public class CountryDetailActivity extends AppCompatActivity {

    ActivityCountryDetailBinding binding;
    CountriesData country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_country_detail);

        country = (CountriesData) getIntent().getSerializableExtra("country");

        Glide.with(this).load(country.getFlag()).into(binding.imgFlag);
        binding.txtName.setText("Name: " + country.getName());
        binding.txtFullName.setText(country.getFull_name());
        binding.txtArea.setText(country.getArea() + "");
        binding.txtPopulation.setText(country.getPopulation() + "");
        binding.txtRegion.setText(country.getRegion());
        binding.txtSubregion.setText(country.getSub_region());
        binding.txtCapital.setText(country.getCapital_name());
        binding.txtCurrency.setText(country.getCurrency());

    }
}