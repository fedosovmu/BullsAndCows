package com.company;

public class Game {
    Player PlayerA;
    Player PlayerB;

    Game (Player playerA, Player playerB) {
        PlayerA = playerA;
        PlayerB = playerB;
        System.out.println("\nНовая игра, (" + PlayerA.Name + " vs " + PlayerB.Name + ")");

        playerA.PickNumber();
        playerB.PickNumber();


        while (true) {
            SecretNumber guessA = PlayerA.SayGuess();
            Result resultA = new Result(PlayerB, guessA);
            PlayerA.History.add(resultA);
            System.out.println(PlayerA.Name + ": " + guessA + " - " + resultA);

            if (resultA.IsWin) {
                System.out.println("Игрок " + PlayerA.Name + " победил!");
                break;
            }

            SecretNumber guessB = PlayerB.SayGuess();
            Result resultB = new Result(PlayerA, guessB);
            PlayerB.History.add(resultB);
            System.out.println(PlayerB.Name + ": " + guessB + " - " + resultB);

            if (resultB.IsWin) {
                System.out.println("Игрок " + PlayerB.Name + " победил!");
                break;
            }
        }

        System.out.println("Конец игры.");
    }
}
