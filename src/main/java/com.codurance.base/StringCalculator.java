package com.codurance.base;

import java.util.List;

public class StringCalculator {
    int Add(String numbers) throws NegativeInputException {
        if ("".equals(numbers))
            return 0;

        int result = 0;

        String delimeter = findDelimeter(numbers);
        String[] nums = getNumbers(numbers).split(delimeter+"|\n");

        List<Integer> negativeNumbers = new java.util.ArrayList<Integer>(List.of());

        for(String number: nums){
            int num = Integer.parseInt(number);
            if(num<0){
                negativeNumbers.add(num);
            }
            result += Integer.parseInt(number);
        }

        if (negativeNumbers.size() > 0) {
            throw new NegativeInputException("Negative values: " + prepareMessageForNegativeValues(negativeNumbers));
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

    String prepareMessageForNegativeValues(List<Integer> negativeNumbers) {
        StringBuilder message = new StringBuilder();

        for (int number : negativeNumbers) {
            message.append(number).append(",");
        }

        return message.substring(0, message.length() -1);

    }
}
