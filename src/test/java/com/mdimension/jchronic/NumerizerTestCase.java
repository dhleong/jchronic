package com.mdimension.jchronic;

import java.util.LinkedHashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.mdimension.jchronic.numerizer.Numerizer;

public class NumerizerTestCase extends TestCase {
  public void testStraightParsing() {
    Map<Integer, String> strings = new LinkedHashMap<Integer, String>();
    strings.put(Integer.valueOf(1), "one");
    strings.put(Integer.valueOf(5), "five");
    strings.put(Integer.valueOf(10), "ten");
    strings.put(Integer.valueOf(11), "eleven");
    strings.put(Integer.valueOf(12), "twelve");
    strings.put(Integer.valueOf(13), "thirteen");
    strings.put(Integer.valueOf(14), "fourteen");
    strings.put(Integer.valueOf(15), "fifteen");
    strings.put(Integer.valueOf(16), "sixteen");
    strings.put(Integer.valueOf(17), "seventeen");
    strings.put(Integer.valueOf(18), "eighteen");
    strings.put(Integer.valueOf(19), "nineteen");
    strings.put(Integer.valueOf(20), "twenty");
    strings.put(Integer.valueOf(27), "twenty seven");
    strings.put(Integer.valueOf(31), "thirty-one");
    strings.put(Integer.valueOf(59), "fifty nine");
    strings.put(Integer.valueOf(100), "a hundred");
    strings.put(Integer.valueOf(100), "one hundred");
    strings.put(Integer.valueOf(150), "one hundred and fifty");
    //   strings.put(Integer.valueOf(150), "one fifty");
    strings.put(Integer.valueOf(200), "two-hundred");
    strings.put(Integer.valueOf(500), "5 hundred");
    strings.put(Integer.valueOf(999), "nine hundred and ninety nine");
    strings.put(Integer.valueOf(1000), "one thousand");
    strings.put(Integer.valueOf(1200), "twelve hundred");
    strings.put(Integer.valueOf(1200), "one thousand two hundred");
    strings.put(Integer.valueOf(17000), "seventeen thousand");
    strings.put(Integer.valueOf(21473), "twentyone-thousand-four-hundred-and-seventy-three");
    strings.put(Integer.valueOf(74002), "seventy four thousand and two");
    strings.put(Integer.valueOf(99999), "ninety nine thousand nine hundred ninety nine");
    strings.put(Integer.valueOf(100000), "100 thousand");
    strings.put(Integer.valueOf(250000), "two hundred fifty thousand");
    strings.put(Integer.valueOf(1000000), "one million");
    strings.put(Integer.valueOf(1250007), "one million two hundred fifty thousand and seven");
    strings.put(Integer.valueOf(1000000000), "one billion");
    strings.put(Integer.valueOf(1000000001), "one billion and one");

    for (Integer value : strings.keySet()) {
      String str = strings.get(value);
      assertEquals(value.intValue(), Integer.parseInt(Numerizer.numerize(str)));
    }
  }
  
  public void testOrdinalStrings() {
      Map<String, String> strings = new LinkedHashMap<String, String>();
      strings.put("1st", "first");
      strings.put("second", "second");
      strings.put("2nd day", "second day");
      strings.put("2nd of may", "second of may");
      strings.put("5th", "fifth");
      strings.put("23rd", "twenty third");
      strings.put("1st day month 2", "first day month two");

      for (String value : strings.keySet()) {
        // Use pre_normalize here instead of Numerizer directly because
        // pre_normalize deals with parsing 'second' appropriately
        String str = strings.get(value);
        assertEquals(value, Chronic.preNormalize(str));
      }
    }
}
