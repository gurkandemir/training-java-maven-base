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

    @Test
    void return_3_when_the_input_string_is_1_comma_2() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.Add("1,2"));
    }

    @Test
    void return_6_when_the_input_string_is_1_comma_2_comma_3() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.Add("1,2,3"));
    }

    @Test
    void return_12_when_the_string_is_3_comma_4_backslashN_5() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(12, calculator.Add("3,4\n5"));
    }

    @Test
    void return_12_when_the_string_is_3_backslashN_4_backslashN_5() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(12, calculator.Add("3\n4\n5"));
    }

    @Test
    void return_12_when_the_string_is_3_backslashN_4_comma_5() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(12, calculator.Add("3\n4,5"));
    }

}
