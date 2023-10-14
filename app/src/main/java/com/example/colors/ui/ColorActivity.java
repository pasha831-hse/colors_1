package com.example.colors.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.colors.R;
import com.example.colors.constants.Constants;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        Intent intent = getIntent();
        int color = intent.getIntExtra(Constants.colorKey, 0);
        getWindow().getDecorView().setBackgroundColor(color);
    }
}