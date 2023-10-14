package com.example.colors.converter;

import android.graphics.Color;

public class TextToHexConverterImpl implements TextToHexConverter {
    @Override
    public int textToHex(String color) {
        return switch(color) {
            case "red" -> Color.RED;
            case "green" -> Color.GREEN;
            case "blue" -> Color.BLUE;
            default -> Color.WHITE;
        };
    }
}
