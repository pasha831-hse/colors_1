package com.example.colors;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.colors.validator.ColorValidator;
import com.example.colors.validator.ColorValidatorImpl;

public class ColorValidatorTest {

    ColorValidator validator;

    @Before
    public void initialize() {
        validator = new ColorValidatorImpl();
    }

    @Test
    public void enterDigit() {
        assertFalse(validator.isValidColor("1"));
    }

    @Test
    public void enterSymbol() {
        assertFalse(validator.isValidColor("$"));
    }

    @Test
    public void enterNotValidColor() {
        assertFalse(validator.isValidColor("black"));
    }

    @Test
    public void enterRandomString() {
        assertFalse(validator.isValidColor("fsdafscsdca31s__2-1231"));
    }

    @Test
    public void enterEmptyString() {
        assertFalse(validator.isValidColor(""));
    }

    @Test
    public void enterRed() {
        assertTrue(validator.isValidColor("red"));
    }

    @Test
    public void enterGreen() {
        assertTrue(validator.isValidColor("green"));
    }

    @Test
    public void enterBlue() {
        assertTrue(validator.isValidColor("blue"));
    }
}