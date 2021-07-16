package com.calulator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

  Pattern numberPattern = Pattern.compile("([0-9])");

  public int add(String numbers) {
    int sum = 0;
    Matcher numberMatcher = numberPattern.matcher(numbers);
    while (numberMatcher.find()) {
      sum = sum + Integer.parseInt(numberMatcher.group(0));
    }
    return sum;
  }

}
