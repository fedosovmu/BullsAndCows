package com.company;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Human extends Player {
   Scanner in;

    Human (String name) {
        super(name);
        in = new Scanner(System.in);
    }

    public void PickNumber () {
        System.out.print(Name + " загадайте число: ");
        Number = new SecretNumber(in.nextInt());

    }
    public SecretNumber SayGuess () {
        System.out.print(Name + ": ");
        return new SecretNumber(in.nextInt());
    }
}
