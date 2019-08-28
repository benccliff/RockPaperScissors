import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static int getUserInput() {

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

        int userAction;
        int opponentAction;
        String result;

        userAction = getUserInput();
        opponentAction = generateOpponentAction();

        result = decideWinner(userAction, opponentAction);
        informUser(result);

    }

}