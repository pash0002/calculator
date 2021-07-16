package com.calulator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

  Pattern numberPattern = Pattern.compile("[-]*([0-9])+");
  Boolean isNegative = false;
  StringBuilder builder = new StringBuilder().append("negatives not allowed ");

  public int add(String numbers) {
    if (isValidInput(numbers))
      throw new UnsupportedOperationException("INVALID input");
    Matcher numberMatcher = numberPattern.matcher(numbers);
    int sum = findNumbersAndCalculateSum(numberMatcher);
    if (isNegative)
      throw new UnsupportedOperationException(builder.substring(0, builder.length() - 2));
    else
      return sum;
  }

  private boolean isValidInput(String numbers) {
    return numbers.endsWith(",") ||
        numbers.endsWith(";") ||
        numbers.endsWith("*") ||
        numbers.endsWith("\\") ||
        numbers.endsWith("/") ||
        numbers.endsWith("%");
  }

  private int findNumbersAndCalculateSum(Matcher numberMatcher) {
    int sum = 0;
    while (numberMatcher.find()) {
      int number = Integer.parseInt(numberMatcher.group(0));
      if (number > 1000 ) {
        continue;
      }
      if (number < 0) {
        isNegative = true;
        builder.append(number).append(", ");
        continue;
      }
      sum = sum + Integer.parseInt(numberMatcher.group(0));
    }
    return sum;
  }

}
