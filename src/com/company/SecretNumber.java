package com.company;

import java.util.Formatter;

public class SecretNumber {
    public int Value;
    public int[] Digits;

    SecretNumber(int a, int b, int c, int d) {
        Value = a * 1000 + b * 100 + c * 10 + d;
        Digits[0] = a;
        Digits[1] = b;
        Digits[2] = c;
        Digits[3] = d;
    }

    SecretNumber (int value) {
        Value = Math.abs(value % 10000);
        Digits = new int[4];
        Digits[3] = Value % 10;
        Digits[2] = (Value / 10) % 10;
        Digits[1] = (Value / 100) % 10;
        Digits[0] = Value / 1000;
    }

    @Override
    public String toString() {
        Formatter f = new  Formatter();
        f.format("%04d", Value);
        return f.toString();
    }
}
