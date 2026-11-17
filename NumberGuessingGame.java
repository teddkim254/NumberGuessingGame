import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
  public static void main(String[] args) {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    
    String playAgain = "yes";

    // ask whether the user want to play again, intitialized to yes
    while (playAgain.equalsIgnoreCase("yes")) {
      System.out.println("\n=============================");
      System.out.println("        NUMBER GUESSING GAME");
      System.out.println("=============================");
      System.out.println("I am thinking of a number..");
      System.out.println("Can you guess it?");
      System.out.println("Good Luck!");

      int secretNumber = random.nextInt(100);
      int maxAttempts = 2;
      int count = 0;
      int guess = 0;

      // i could also use a for loop for (int count = 1; count <= maxAttempts; count++ {..}
      while (guess != secretNumber && count < maxAttempts) {
        
        // RETRY LOOP to handle invalid user input
        while (true) {
          try {
            System.out.print("\nEnter your guess: ");
            guess = scanner.nextInt();
            break; // leave the retry loop
          } catch (InputMismatchException e) {
            System.out.println("Invalid Input! Please enter a whole number!");
            scanner.nextLine(); // discard the invalid input from buffer (memory!)
          }
        }

        if (guess > 0 && guess <= 100) {
          count++;

          if (guess == secretNumber) {
            System.out.println("\nCongrats!");
            System.out.println("The number was " + secretNumber + "!");
            System.out.println("Number of attempts: " + count);
            scanner.close();
            break;
          }

          if (count == maxAttempts) {
            System.out.println("Game Over!");
            System.out.println("You have used all of your " + maxAttempts + " attempts.");
            System.out.println("The secret number was " + secretNumber + ".");
            break;
          }

          if (guess > secretNumber) {
            System.out.println("Too High! Try a lower number.");
          } else {
            System.out.println("Too Low! Try a higher number.");
          }
        } else {
          System.out.println("Out of range 1 to 100!");
        }
      }
      System.out.print("Do you want to play again? (yes/no): ");
      playAgain = scanner.next();
    }
    scanner.close();
  }
}