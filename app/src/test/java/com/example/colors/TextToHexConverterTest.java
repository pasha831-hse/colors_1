package com.example.colors;

import static org.junit.Assert.assertEquals;

import android.graphics.Color;

import com.example.colors.converter.TextToHexConverter;
import com.example.colors.converter.TextToHexConverterImpl;

import org.junit.Before;
import org.junit.Test;

public class TextToHexConverterTest {

    TextToHexConverter converter;

    @Before
    public void init() {
        converter = new TextToHexConverterImpl();
    }

    @Test
    public void enterRed() {
        assertEquals(converter.textToHex("red"), Color.RED);
    }

    @Test
    public void enterGreen() {
        assertEquals(converter.textToHex("green"), Color.GREEN);
    }

    @Test
    public void enterBlue() {
        assertEquals(converter.textToHex("blue"), Color.BLUE);
    }

    @Test
    public void enterNotValidColor() {
        assertEquals(converter.textToHex("yellow"), Color.WHITE);
    }

    @Test
    public void enterEmptyString() {
        assertEquals(converter.textToHex(""), Color.WHITE);
    }
}
