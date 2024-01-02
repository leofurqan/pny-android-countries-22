package com.example.countriesapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.countriesapp.R;
import com.example.countriesapp.adapters.CategoriesAdapter;
import com.example.countriesapp.adapters.ProductsAdapter;
import com.example.countriesapp.data.CategoriesData;
import com.example.countriesapp.interfaces.ClickListener;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductsFragment extends Fragment implements ClickListener {

    Context context;

    ArrayList<CategoriesData> categories;

    RecyclerView rvCategories, rvProducts;
    CategoriesAdapter categoriesAdapter;
    ProductsAdapter productsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container,  false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        categories = new ArrayList<>();

        rvCategories = view.findViewById(R.id.rv_categories);
        categoriesAdapter = new CategoriesAdapter(categories, context);
        rvCategories.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        categoriesAdapter.setOnClickListener(this);
        rvCategories.setAdapter(categoriesAdapter);

        loadCategories();
    }

    private void loadCategories() {
        StringRequest request = new StringRequest(Request.Method.GET, "http://192.168.124.166/app/categories.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray categoriesArray = jsonObject.getJSONArray("categories");

                    for(int i = 0; i < categoriesArray.length(); i++) {
                        JSONObject categoryObject = categoriesArray.getJSONObject(i);
                        categories.add(new Gson().fromJson(categoryObject.toString(), CategoriesData.class));
                    }

                    categories.get(0).setSelected(true);

                    categoriesAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("e_categories", error.toString());
            }
        });

        Volley.newRequestQueue(context).add(request);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCategoryClick(int position) {
        for(int i = 0; i < categories.size(); i++) {
            categories.get(i).setSelected(false);
        }

        categories.get(position).setSelected(true);
        categoriesAdapter.notifyDataSetChanged();
    }
}
