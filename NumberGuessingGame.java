import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int maxAttempts = 5;
        int roundsWon = 0;
        boolean playAgain = true;
        while (playAgain) {
            int attempts = 0;
            int number = rand.nextInt(100) + 1;
            System.out.println("I'm thinking of a number between 1 and 100. You have " + maxAttempts + " attempts to guess it.");
            while (attempts < maxAttempts) {
                System.out.println("Enter your guess: ");
                int guess = sc.nextInt();
                if (guess == number) {
                    System.out.println("Congratulations! You guessed the number in " + (attempts + 1) + " attempts.");
                    roundsWon++;
                    break;
                } else if (guess < number) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
                attempts++;
            }
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you ran out of attempts. The number was " + number + ".");
            }
            System.out.println("Do you want to play again? (y/n)");
            char c = sc.next().charAt(0);
            playAgain = (c == 'y' || c == 'Y');
        }
        System.out.println("You won " + roundsWon + " rounds. Thanks for playing!");
    }
}
