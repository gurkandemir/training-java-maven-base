package com.codurance.base;

public class StringCalculator {
    int Add(String numbers){
        if ("".equals(numbers))
            return 0;

        int result = 0;


        String[] nums = numbers.split(",|\n");

        for(String number: nums){
            result += Integer.parseInt(number);
        }

        return result;
    }
}
