package com.codurance.base;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class StringCalculator {
    int Add(String numbers) throws NegativeInputException {
        if (StringUtils.isEmpty(numbers))
            return 0;

        int result = 0;

        String delimeter = findDelimeter(numbers);
        String[] nums = getNumbers(numbers).split(delimeter+"|\n");

        List<Integer> negativeNumbers = new java.util.ArrayList<>(List.of());

        for(String number: nums){
            int num = Integer.parseInt(number);
            if(num<0){
                negativeNumbers.add(num);
            }
            if(num<1000){
                result += num;
            }

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
            String tempDelimeter = delimeters[0].substring(2);
            StringBuilder delimeter = new StringBuilder();
            for (int i = 0; i < tempDelimeter.length(); i++) {
                if (tempDelimeter.charAt(i) == '*') {
                    delimeter.append("\\").append(tempDelimeter.charAt(i));
                } else {
                    delimeter.append(tempDelimeter.charAt(i));
                }
            }

            return delimeter.toString();
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
        return StringUtils.join(negativeNumbers, ",");
    }
}
