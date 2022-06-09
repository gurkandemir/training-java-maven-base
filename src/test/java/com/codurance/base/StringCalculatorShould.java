package com.codurance.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StringCalculatorShould {

    @Test
    void return_0_when_empty_string_given() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.Add(""));
    }


    @Test
    void return_1_when_the_input_string_is_1() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.Add("1"));
    }
}
