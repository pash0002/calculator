package com.calculator;

import com.calulator.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorSpec {

  private final StringCalculator calculator = new StringCalculator();

  @Test
  void additionForBlankInput() {
    assertEquals(0, calculator.add(""));
  }

  @Test
  void additionForSingleNumberInput() {
    assertEquals(1, calculator.add("1"));
  }

  @Test
  void additionForTwoNumberInput() {
    assertEquals(3, calculator.add("1,2"));
  }

  @Test
  void additionMultipleNumberInput() {
    assertEquals(15, calculator.add("1,2,3,4,5"));
  }

  @Test
  void additionOfNumberWithNewline() {
    assertEquals(6, calculator.add("1\n2,3"));
  }

  @Test
   void invalidInput() {
    Exception exception = assertThrows(UnsupportedOperationException.class, () -> calculator.add("//;\\n1;"));
    assertEquals("INVALID input", exception.getMessage());
  }

  @Test
  void additionOfNumberWithSpecialCharacters() {
    assertEquals(3, calculator.add("//;\\n1;2"));
  }

  @Test
  void negativeNumbersInput() {
    Exception exception = assertThrows(UnsupportedOperationException.class, () -> calculator.add("-1,-2,-3"));
    assertEquals("negatives not allowed -1, -2, -3", exception.getMessage());
  }

}
