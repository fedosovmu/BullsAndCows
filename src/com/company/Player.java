package com.company;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Player {
    String Name;
    SecretNumber Number;
    ArrayList<Result> History;

    Player (String name) {
        History = new ArrayList<Result>();
        Name = name;
    }

    public void AddToHistory (Result result) {
        History.add(result);
    }

    public abstract void PickNumber ();
    public abstract SecretNumber SayGuess ();
}
