package com.company;
import java.util.Scanner;

public class Menu {
    Scanner in;

    Menu () {
        in = new Scanner(System.in);
        System.out.println(" ------ Игра \"Быки и коровы\" ------ ");

        Player playerA = SelectPlayer(1, 2);
        Player playerB = SelectPlayer(2, 2);

        new Game(playerA, playerB);
    }



    void PrintNumber (Player player) {
        System.out.printf ("игрок %s загадал: %s\n", player.Name, player.Number);
    }



    Player SelectPlayer (int playerNumber, int mode) {
        while (true) {
            System.out.println("Выберите игрока номер " + playerNumber);
            System.out.println("1 - Игрок");
            System.out.println("2 - Легкий ИИ");
            System.out.println("3 - Сложный ИИ");
            System.out.print("режим: ");
            //int mode = 1;
            System.out.println(mode); // <---------------------
            //int mode = in.nextInt();
            switch (mode) {
                case 1:
                    return new Human("Human" + playerNumber);
                case 2:
                    return new EasyAI("AI" + playerNumber);
                case 3:
                    System.out.println("Функция " + mode + " не реализована");
                    break;
                default:
                    System.out.println("Недопустимое значение");
                    break;
            }
        }
    }
}
