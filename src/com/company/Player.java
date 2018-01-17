package com.company;
import java.util.List;
import java.util.Scanner;

public class Player {
    Scanner in;
    String Name;
    SecretNumber Number;
    List<Result> History;

    Player (String name) {
        in = new Scanner(System.in);
        Name = name;
    }

    public void PickNumber () {
        System.out.print(Name + " введите число: ");
        Number = new SecretNumber(in.nextInt());
    }

    public SecretNumber SayGuess () {
        System.out.print(Name + ": ");
        return new SecretNumber(in.nextInt());
    }
}
