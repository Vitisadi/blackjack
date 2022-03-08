package com.Tim;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        BlackJack player = new BlackJack(0, "Player");

        player.hit();
        player.hit();
        player.sendDefaultMessage();
        int userInputValue;
        while (player.amount < 21 && !player.stand) {
            if (userInputScanner.hasNextInt()) {
                userInputValue = userInputScanner.nextInt();
                if (userInputValue == 1) {
                    player.hit();
                    player.sendDefaultMessage();
                } else if (userInputValue == 2) {
                    player.stand();
                } else {
                    player.sendErrorMessage();
                }
            } else {
                player.sendErrorMessage();
                userInputScanner.next();
            }
        }

        BlackJack dealer = countDealer(player.amount);
            if (player.amount > 21) {
                System.out.println("Awww! You busted!");
            } else if (player.amount == 21) {
                System.out.println("PERFECT 21 points! You WIN!");
            } else if (dealer.amount > 21) {
                dealer.printPastNumbers();
                System.out.println("You WIN! The dealer busted with " + dealer.amount + " points!");
            } else if (dealer.amount <= player.amount) {
                player.sendWinningMessage();
                dealer.printPastNumbers();
            } else {
                dealer.printPastNumbers();
                player.sendLosingMessage();
        }
    }

    static BlackJack countDealer(int playerAmount) {
        BlackJack dealer = new BlackJack(0, "Dealer");
        while (dealer.amount < 21 && dealer.amount <= playerAmount) {
            dealer.hit();
            dealer.addRole();
        }
        dealer.stand = true;
        return dealer;
    }
}
