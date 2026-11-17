import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ModularNumberGuessingGame {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    String playAgain = "yes";

    while (playAgain.equalsIgnoreCase("yes")) {
      playRound(scanner, random);

      System.out.print("Do you want to play again? (yes/no): ");
      playAgain = getValidYesNo(scanner);
    }

    System.out.println("Thanks for playing!");
    scanner.close();
  }

  private static void playRound(Scanner scanner, Random random) {
    System.out.println("\n=============================");
    System.out.println("        NUMBER GUESSING GAME");
    System.out.println("=============================");
    System.out.println("I am thinking of a positive integer between 1 and 100.");
    System.out.println("Can you guess it?");
    System.out.println("You have 5 attempts. Good luck!");

    int secretNumber = random.nextInt(100) + 1;
    int maxAttempts = 5;

    for (int attempt = 1; attempt <= maxAttempts; attempt++) {
      int guess = getValidGuess(scanner);

      if (guess == secretNumber) {
        System.out.println("\nCongrats!");
        System.out.println("The number was " + secretNumber + "!");
        System.out.println("Attempts used: " + attempt);
        return;
      }

      if (guess < secretNumber) {
        System.out.println("Too Low! Try a higher number.");
      } else {
        System.out.println("Too High! Try a lower number.");
      }

      if (attempt == maxAttempts) {
        System.out.println("\nGame Over!");
        System.out.println("You have used all of your " + maxAttempts + " attempts.");
        System.out.println("The secret number was " + secretNumber + ".");
      }
    }
  }

  private static int getValidGuess(Scanner scanner) {
    while (true) {
      try {
        System.out.print("\nEnter your guess: ");
        int guess = scanner.nextInt();

        if (guess < 1 && guess >= 100) {
          System.out.println("Guess out of range! Between 1 and 100 only!.");
          continue;
        }

        return guess;
      } catch (InputMismatchException e) {
        System.out.println("Invalid input! Please enter a whole number.");
        scanner.nextLine(); // to clear the input buffer by consuming the token
      }
    }
  }

  private static String getValidYesNo(Scanner scanner) {
    while (true) {
      String answer = scanner.next().trim();

      if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
        return "yes";
      }

      if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
        return "no";
      }

      System.out.print("Please enter only yes or no: ");
    }
  }
}
