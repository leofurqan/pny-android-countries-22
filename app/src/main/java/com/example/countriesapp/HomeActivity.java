package com.example.countriesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.countriesapp.adapters.CountriesAdapter;
import com.example.countriesapp.data.CountriesData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    String url = "https://restcountries.com/v3.1/all";
    ArrayList<CountriesData> countries;
    CountriesAdapter  adapter;
    RecyclerView rvCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvCountries = findViewById(R.id.rv_countries);
        countries = new ArrayList<>();
        adapter = new CountriesAdapter(this, countries);
        rvCountries.setAdapter(adapter);
        rvCountries.setLayoutManager(new GridLayoutManager(this, 2));

        loadCountries();
    }

    private void loadCountries() {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("r_countries", response);
                try {
                    JSONArray countriesArray = new JSONArray(response);

                    for(int i = 0; i < countriesArray.length(); i++) {
                        CountriesData country = new CountriesData();
                        JSONObject countryObject = countriesArray.getJSONObject(i);
                        JSONObject nameObject = countryObject.getJSONObject("name");
                        JSONObject flagObject = countryObject.getJSONObject("flags");

                        country.setName(nameObject.getString("common"));
                        country.setFull_name(nameObject.getString("official"));
                        country.setFlag(flagObject.getString("png"));

                        countries.add(country);
                    }

                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("e_countries", error.toString());
            }
        });

        Volley.newRequestQueue(this).add(request);
    }
}