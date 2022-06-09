package com.codurance.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class StringCalculatorShould {

    @Test
    void return_0_when_empty_string_given() {
        StringCalculator calculator = new StringCalculator();
        calculator.Add("");
    }
}
