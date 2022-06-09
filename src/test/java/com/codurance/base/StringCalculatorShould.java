package com.codurance.base;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorShould {

    @ParameterizedTest
    @MethodSource(value = "inputsForCalculator")
    void return_summation_according_to_input(String input, int expected) {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.Add(input);

        // then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputsForCalculator() {
        return Stream.of(
            Arguments.of("", 0),
            Arguments.of("1", 1),
            Arguments.of("2", 2),
            Arguments.of("1,2", 3),
            Arguments.of("1,2,3", 6),
            Arguments.of("3,4\n5", 12),
            Arguments.of("3\n4\n5", 12),
            Arguments.of("3\n4,5", 12),
            Arguments.of("//;\n3\n4;5", 12),
            Arguments.of("//;\n3\n4\n5", 12),
            Arguments.of("//;\n3;4;5", 12),
            Arguments.of("//!\n3!4!5", 12)
        );
    }
}
