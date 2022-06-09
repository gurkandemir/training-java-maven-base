package com.codurance.base;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorShould {

    @ParameterizedTest
    @MethodSource(value = "inputsForCalculator")
    void return_summation_according_to_input(String input, int expected) throws NegativeInputException {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.Add(input);

        // then
        assertEquals(expected, result);
    }

    @Test
    void throw_exception_when_input_is_negative() {
        // given
        StringCalculator calculator = new StringCalculator();
        String input = "-1";

        // when
        NegativeInputException thrown = assertThrows(
            NegativeInputException.class,
            () -> calculator.Add(input)
        );

        // then
        assertTrue(thrown.getMessage().contains("Negative values: -1"));
    }

    @Test
    void throw_exception_when_input_has_multiple_negatives() {
        // given
        StringCalculator calculator = new StringCalculator();
        String input = "-1,-2";

        // when
        NegativeInputException thrown = assertThrows(
            NegativeInputException.class,
            () -> calculator.Add(input)
        );

        // then
        assertTrue(thrown.getMessage().contains("Negative values: -1,-2"));
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
