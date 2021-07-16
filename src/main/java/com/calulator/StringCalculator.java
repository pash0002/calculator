package com.calulator;

public class StringCalculator {

  public int add(String numbers) {
    if (numbers.length() == 0 && "".equals(numbers)) {
      return 0;
    } else if (numbers.length() == 1) {
      return Integer.parseInt(numbers);
    } else {
      String[] nos = numbers.split(",");
      int sum = 0;
      for (String no : nos) {
        sum = sum + Integer.parseInt(no);
      }
      return sum;
    }
  }

}
