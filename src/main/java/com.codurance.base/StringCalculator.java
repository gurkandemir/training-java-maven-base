package com.codurance.base;

public class StringCalculator {
    int Add(String numbers){
        if ("".equals(numbers))
            return 0;

        return Integer.parseInt(numbers);
    }
}
