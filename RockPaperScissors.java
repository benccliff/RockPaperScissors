import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    // A short program to play a game of rock, paper, scissors using user input.

    static int getUserInput() {

        /*
        Prompts the user to enter their move, reads this from the command line, and converts their move to an
        integer between 0 and 2 inclusive (or 3 if they provide an invalid move). Returns said integer.
         */

        Scanner input = new Scanner(System.in);
        String userInput;
        int userAction;

        System.out.println("Do you want to play rock, paper or scissors?");
        userInput = input.nextLine();

        if (userInput.equals("rock")) {
            userAction = 0;
        } else if (userInput.equals("paper")) {
            userAction = 1;
        } else if (userInput.equals("scissors")) {
            userAction = 2;
        } else {
            userAction = 3;
        }

        return userAction;

    }

    static int generateOpponentAction() {

        /*
        Randomly generates a move for the opponent, informs the user of the move, and then returns an integer between
        0 and 2 inclusive corresponding to this move.
         */

        Random randomGenerator = new Random();
        int opponentAction;

        opponentAction = randomGenerator.nextInt(3);

        if (opponentAction == 0) {
            System.out.println("Your opponent played rock.");
        } else if (opponentAction == 1) {
            System.out.println("Your opponent played paper.");
        } else {
            System.out.println("Your opponent played scissors.");
        }

        return opponentAction;

    }

    static String decideWinner(int player, int opponent) {

        /*
        Takes as arguments the moves of the player and the opponent, and returns the winner of the game as a string.
         */

        String result;

        if ((player == 0 && opponent == 1) || (player == 1 && opponent == 2) || (player == 2 && opponent == 0)) {
            result = "opponent";
        } else if ((player == 1 && opponent == 0) || (player == 2 && opponent == 1) || (player == 0 && opponent == 2)) {
            result = "player";
        } else if (player == opponent) {
            result = "draw";
        } else {
            result = "invalid";
        }

        return result;

    }

    static void informUser(String result) {

        /*
        Informs the user of the result of the game.
         */

        if (result.equals("opponent")) {
            System.out.println("Bad luck - you lost!");
        } else if (result.equals("player")) {
            System.out.println("Well done! You won!");
        } else if (result.equals("draw")) {
            System.out.println("Wow; it's a tie!");
        } else {
            System.out.println("Invalid move; enter either rock, paper or scissors.");
        }

    }

    public static void main(String[] args) {

        /*
        Orchestrates the high level logic of the program.
         */

        int userAction;
        int opponentAction;
        String result;

        userAction = getUserInput();
        opponentAction = generateOpponentAction();

        result = decideWinner(userAction, opponentAction);
        informUser(result);

    }

}