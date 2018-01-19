package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class EasyAI extends Player {
    static Random rand = new Random(System.currentTimeMillis());;

    EasyAI (String name) {
        super(name);
    }

    public void PickNumber () {
        Number = new SecretNumber(rand.nextInt());
        System.out.println(Name + " выбрал число: " + "****");
    }

    public SecretNumber SayGuess () {
        // Часть 1 определение чисел содержащихсф в числе
        HashSet<Integer> guesses = new HashSet<>();
        int[] findedDigits = new int[] {0,0,0,0,0,0,0,0,0,0};
        boolean findAllDigits = false;

        if (History.size() != 0) {
            int sum = 0;
            for (Result result: History) {
                guesses.add(result.Guess.Value);
                int num = result.Guess.Digits[0];
                if (num == result.Guess.Digits[1] && num == result.Guess.Digits[2] && num == result.Guess.Digits[3]) {
                    findedDigits[num] += result.Bulls;
                    sum += result.Bulls;
                    if (sum >= 4) {
                        findAllDigits = true;
                    }
                }
            }
        }

        if (!findAllDigits) {
            int digit = History.size() % 10;
            return new SecretNumber(new int[]{digit, digit, digit, digit});
        }

        // Часть 2 Все возможные комбинации

        int index = 0;
        int number[] = new int [4];
        for (int i = 0; i < 10; i++) { ;
            while (findedDigits[i] > 0) {
                findedDigits[i]--;
                number[index] = i;
                index++;
            }
        }

        int guess[] = new int[] {0, 0, 0, 0};
        int counter = 0;

        while (guesses.contains(numToValue(guess))) {
            guess = new int[] {0, 0, 0, 0};

            int a = (counter % 4);
            guess[a] = number[0];

            int b = (a + (counter / 4) % 3 + 1) % 4;
            guess[b] = number[1];


            int c = 0;
            while (c == a || c == b) {
                c = (c + 1) % 4;
            }
            int d = 0;
            while (d == a || d == b || d == c) {
                d = (d + 1) % 4;
            }

            int f = (counter / 12) % 2;
            if (f == 0) {
                guess[c] = number[2];
                guess[d] = number[3];
            }
            else {
                guess[c] = number[3];
                guess[d] = number[2];
            }

            counter++;
        }

        return  new SecretNumber(guess);
    }

    private int numToValue (int[] number) {
        return number[0] * 1000 + number[1] * 100 + number[2] * 10 + number[3];
    }
}
