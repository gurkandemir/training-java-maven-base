package com.codurance.base;

public class StringCalculator {
    int Add(String numbers){
        if ("".equals(numbers))
            return 0;

        int result = 0;

        String delimeter = findDelimeter(numbers);
        String[] nums = getNumbers(numbers).split(delimeter+"|\n");

        for(String number: nums){
            result += Integer.parseInt(number);
        }

        return result;
    }

    boolean isDelimeterGiven(String input){
        return input.startsWith("//");
    }

    String findDelimeter(String input){
        if(isDelimeterGiven(input)){
            String[] delimeters = input.split("\n"); // "//,\n3,4,5"
            return delimeters[0].substring(2);
        }

        return ",";
    }

    String getNumbers(String input){
        if(isDelimeterGiven(input)){
            String[] delimeters = input.split("\n", 2); // "//,\n3\n4,5" -> ["//,","3\n4,5"]
            return delimeters[1];
        }

        return input;
    }
}
