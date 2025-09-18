package com.example.calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void sumTest() {
        assertEquals(10.0, calculator.sum(5.0, 5.0));
    }

    @Test
    void numbersNullSumTest() {
        assertThrows(NullPointerException.class, () -> calculator.sum(null, 5.0));
        assertThrows(NullPointerException.class, () -> calculator.sum(5.0, null));
    }

    @Test
    void subTest() {
        assertEquals(5.0, calculator.sub(10.0, 5.0));
    }

    @Test
    void divideTest() {
        assertEquals(2.5, calculator.divide(5.0, 2.0));
    }

    @Test
    public void divisionByZeroTest() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10.0, 0.0));
    }

    @Test
    void factorialTest() {
        assertEquals(120, calculator.factorial(5));
    }

    @Test
    void integerToBinaryTest() {
        assertEquals("1", calculator.integerToBinary(1));
        assertEquals("101", calculator.integerToBinary(5));
        assertEquals("10100", calculator.integerToBinary(20));
    }

    @Test
    void integerToHexadecimalTest() {
        assertEquals("1", calculator.integerToHexadecimal(1));
        assertEquals("5", calculator.integerToHexadecimal(5));
        assertEquals("aa", calculator.integerToHexadecimal(170));
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate date1 = LocalDate.of(2020, 3, 15);
        LocalDate date2 = LocalDate.of(2020, 3, 29);
        assertEquals(14, calculator.calculeDayBetweenDate(date1, date2));
    }
}