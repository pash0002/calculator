package com.calculator;

import com.calulator.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorSpec {

  private final StringCalculator calculator = new StringCalculator();

  @Test
  void additionForBlankInput() {
    assert calculator.add("") == 0;
  }

  @Test
  void additionForSingleNumberInput() {
    assert calculator.add("1") == 1;
  }

  @Test
  void additionForTwoNumberInput() {
    assert calculator.add("1,2") == 3;
  }

  @Test
  void additionMultipleNumberInput() {
    assert calculator.add("1,2,3,4,5") == 15;
  }

  @Test
  void additionOfNumberWithNewline() {
    assert calculator.add("1\n2,3") == 6;
  }

  @Test
   void invalidInput() {
    Exception exception = assertThrows(UnsupportedOperationException.class, () -> calculator.add("//;\\n1;"));
    assert"INVALID input".equals(exception.getMessage());
  }

  @Test
  void additionOfNumberWithSpecialCharacters() {
    assert calculator.add("//;\\n1;2") == 3;
  }

}
