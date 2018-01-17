package com.company;

public class Game {
    Player PlayerA;
    Player PlayerB;

    Game (Player playerA, Player playerB) {
        PlayerA = playerA;
        PlayerB = playerB;
        System.out.println("Новая игра, (" + PlayerA.Name + " vs " + PlayerB.Name + ")");

        playerA.PickNumber();
        playerB.PickNumber();


        while (true) {
            SecretNumber guessA = playerA.SayGuess();
            Result resultA = new Result(playerB, guessA);
            System.out.println(resultA);

            if (resultA.IsWin) {
                System.out.println("Игрок " + playerA.Name + " победил!");
                break;
            }

            SecretNumber guessB = playerB.SayGuess();
            Result resultB = new Result(playerA, guessB);
            System.out.println(resultB);

            if (resultB.IsWin) {
                System.out.println("Игрок " + playerB.Name + " победил!");
                break;
            }
        }

        System.out.println("Конец игры.");
    }
}
