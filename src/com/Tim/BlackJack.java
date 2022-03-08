package com.Tim;
import java.util.ArrayList;
import java.util.Random;

public class BlackJack {
    int amount;
    int highBound = 11;
    boolean stand;
    String name;
    ArrayList<Integer> pastNumbers = new ArrayList<Integer>();;

    BlackJack(int amount, String name) {
        this.amount = amount;
        this.stand = false;
        this.name = name;
    }

    void addRole(){
        pastNumbers.add(amount);
    }

    void printPastNumbers(){
        for (Integer pastNumber : pastNumbers) {
            System.out.println("The " + name + "'s amount is " + pastNumber + "\n"
                    + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    Integer addAmount(){
        Random random = new Random();
        return random.nextInt(11) + 1;
    }

    void hit() {
        amount += addAmount();
    }
    void stand() {
         stand = true;
    }

    void sendDefaultMessage() {
        System.out.println("Your current amount is: " + amount + "! \n"
                + "Would you like to hit or stand? \n"
                + "1 = Hit 2 = Stand \n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    void sendWinningMessage() {
        System.out.println("You win with a score of " + amount + "! \n"
                + "This is higher than the dealer! You win!");
    }

    void sendLosingMessage() {
        System.out.println("Your current amount is: " + amount + "! \n"
                + "This is lower than the dealer! You lose!");
    }

    void sendErrorMessage(){
        System.out.println("ERROR! Please only enter the integers 1 or 2");
    }
}