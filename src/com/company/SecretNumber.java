package com.company;

import java.util.Formatter;

public class SecretNumber {
    public int Value;
    public int[] Digits;

    SecretNumber (int[] digits) {
        Digits = new int[4];
        Digits[0] = Math.abs(digits[0] % 10);
        Digits[1] = Math.abs(digits[1] % 10);
        Digits[2] = Math.abs(digits[2] % 10);
        Digits[3] = Math.abs(digits[3] % 10);
        Value = Digits[0] * 1000 + Digits[1] * 100 + Digits[2] * 10 + Digits[3];
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
