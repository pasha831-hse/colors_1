package com.example.colors.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.colors.R;
import com.example.colors.constants.Constants;
import com.example.colors.converter.TextToHexConverter;
import com.example.colors.converter.TextToHexConverterImpl;
import com.example.colors.validator.ColorValidator;
import com.example.colors.validator.ColorValidatorImpl;

public class MainActivity extends AppCompatActivity {

    ColorValidator validator = new ColorValidatorImpl();
    TextToHexConverter converter = new TextToHexConverterImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button openActivityButton = findViewById(R.id.button_open_activity);
        EditText enterColorEditText = findViewById(R.id.edit_text_enter_color);

        openActivityButton.setOnClickListener(button -> {
            String enteredText = enterColorEditText.getText().toString();

            if (!validator.isValidColor(enteredText)) {
                enterColorEditText.setError(getString(R.string.enter_color_error));
            } else {
                Intent openColorActivityIntent = new Intent(this, ColorActivity.class);
                int colorHex = converter.textToHex(enteredText);

                openColorActivityIntent.putExtra(Constants.colorKey, colorHex);
                startActivity(openColorActivityIntent);
            }
        });
    }
}