package com.example.countriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PhoneActivity extends AppCompatActivity {

    EditText etPhone;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        etPhone = findViewById(R.id.et_phone);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(v -> {
            if(!TextUtils.isEmpty(etPhone.getText().toString())) {
                Intent intent = new Intent(this, OTPActivity.class);
                intent.putExtra("phone", etPhone.getText().toString());
                startActivity(intent);
            } else {
                Toast.makeText(this, "Phone no is required!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}