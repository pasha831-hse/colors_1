package com.example.colors.validator;

import java.util.Arrays;
import java.util.List;

public interface ColorValidator {

    List<String> validColors = Arrays.asList("red", "green", "blue");

    boolean isValidColor(String enteredText);
}

