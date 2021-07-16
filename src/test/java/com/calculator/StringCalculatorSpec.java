package com.calculator;

import com.calulator.StringCalculator;
import org.junit.jupiter.api.Test;

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

}
