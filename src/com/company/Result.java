package com.company;

public class Result {
    public SecretNumber Guess;
    public int Bulls;
    public int Cows;
    public boolean IsWin;

    Result(Player player, SecretNumber guess) {
        Guess = guess;
        int bulls = 0, cows = 0;

       for (int x: player.Number.Digits) {
            Boolean flag = false;
            for (int y: guess.Digits) {
                if (x == y) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                cows++;
        }

        for (int i = 0; i < 4; i++) {
            if (player.Number.Digits[i] == guess.Digits[i]) {
                bulls++;
                cows--;
            }
        }

        Bulls = bulls;
        Cows = cows;
        IsWin = (Bulls == 4);
    }

    @Override
    public String toString() {
        return Bulls + "б " + Cows + "к";
    }
}
