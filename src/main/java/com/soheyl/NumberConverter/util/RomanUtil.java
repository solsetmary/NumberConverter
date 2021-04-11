package com.soheyl.NumberConverter.util;

import java.util.TreeMap;

import org.springframework.stereotype.Component;

@Component
public class RomanUtil  implements IRomanUtil {

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    @Override
    public String number(Integer number) {
        if (number < 1)
            throw new NumberFormatException("Value of RomanNumeral must be positive.");
         if (number > 3999)
            throw new NumberFormatException("Value of RomanNumeral must be 3999 or less.");
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + number(number-l);
    }

    @Override
    public String binary(String binary) {
        return number(Integer.parseInt(binary, 2));
    }
}
