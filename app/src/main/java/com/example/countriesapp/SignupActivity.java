package com.example.countriesapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.countriesapp.databinding.ActivitySignupBinding;
import com.example.countriesapp.helpers.DBHelper;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    String url = "http://192.168.151.234/app/register.php";
    ActivitySignupBinding binding;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);

        dbHelper = new DBHelper(this);

        binding.btnRegister.setOnClickListener(v -> {
            if(validation()) {
//                saveUserData();
                String username = binding.etUsername.getText().toString();
                String email = binding.etEmail.getText().toString();
                String phone = binding.etPhone.getText().toString();

                dbHelper.insertUser(username, email, phone);
            }
        });
    }

    private void saveUserData() {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("r_user", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("e_user", error.toString());
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("username", binding.etUsername.getText().toString());
                params.put("email", binding.etEmail.getText().toString());
                params.put("phone", binding.etPhone.getText().toString());
                params.put("password", binding.etPassword.getText().toString());

                return params;
            }
        };

        Volley.newRequestQueue(this).add(request);
    }

    private boolean validation() {
        if(TextUtils.isEmpty(binding.etUsername.getText().toString())) {
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        } else if(TextUtils.isEmpty(binding.etEmail.getText().toString())) {
            Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show();
            return false;
        } else if(TextUtils.isEmpty(binding.etPhone.getText().toString())) {
            Toast.makeText(this, "Phone is required", Toast.LENGTH_SHORT).show();
            return false;
        } else if(TextUtils.isEmpty(binding.etPassword.getText().toString())) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        } else if(TextUtils.isEmpty(binding.etCPassword.getText().toString())) {
            Toast.makeText(this, "Confirm Password is required", Toast.LENGTH_SHORT).show();
            return false;
        } else if(!binding.etPassword.getText().toString().equals(binding.etCPassword.getText().toString())) {
            Toast.makeText(this, "Password doesn't match", Toast.LENGTH_SHORT).show();
            return false;
        } else if(binding.etPassword.getText().length() < 6) {
            Toast.makeText(this, "Password too short", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}