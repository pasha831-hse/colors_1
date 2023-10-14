package com.example.colors.validator;

public class ColorValidatorImpl implements ColorValidator {

    @Override
    public boolean isValidColor(String enteredText) {
        return validColors.contains(enteredText);
    }
}
