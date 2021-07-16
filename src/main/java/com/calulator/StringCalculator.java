package com.calulator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

  Pattern numberPattern = Pattern.compile("[-]*([0-9])");
  Boolean isNegative = false;
  StringBuilder builder = new StringBuilder().append("negatives not allowed ");

  public int add(String numbers) {
    if (numbers.endsWith(",") || numbers.endsWith(";"))
      throw new UnsupportedOperationException("INVALID input");
    int sum = 0;
    Matcher numberMatcher = numberPattern.matcher(numbers);
    while (numberMatcher.find()) {
      int number = Integer.parseInt(numberMatcher.group(0));
      if (number < 0) {
        isNegative = true;
        builder.append(number).append(", ");
        continue;
      }
      sum = sum + Integer.parseInt(numberMatcher.group(0));
    }
    if (isNegative)
      throw new UnsupportedOperationException(builder.substring(0, builder.length() - 2));
    return sum;
  }

}
