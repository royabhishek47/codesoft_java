/*Task 1
  Number Game
 * Generate a random number within a specified range, such as 1 to 100.

2. Prompt the user to enter their guess for the generated number.

3. Compare the user's guess with the generated number and provide feedback on whether the guess
is correct, too high, or too low.

4. Repeat steps 2 and 3 until the user guesses the correct number.

You can incorporate additional details as follows:

5. Limit the number of attempts the user has to guess the number.
6. Add the option for multiple rounds, allowing the user to play again.
7. Display the user's score, which can be based on the number of attempts taken or rounds won.
 * 
 */

import java.util.Scanner;

public class Numbergame {

        // This part is the Function that implements the number guessing game
        public static void guessingNumberGame() {
                // This part is Scanner Class
                Scanner sc = new Scanner(System.in);

                // It Generate the numbers
                int number = 1 + (int) (100
                                * Math.random());

                // Given K trials to users
                int K = 5;

                int i, guess;

                System.out.println(
                                "A number is chosen"
                                                + " between 1 to 100."
                                                + "Guess what the number is chosen?"
                                                + " within 5 trials.");

                // Iterate over K Trials
                for (i = 0; i < K; i++) {

                        System.out.println(
                                        "Guess the number:");

                        // Take input for guessing
                        guess = sc.nextInt();

                        // If the number is guessed
                        if (number == guess) {
                                System.out.println(
                                                "Congratulations!"
                                                                + " You guessed the number.");
                                break;
                        } else if (number > guess
                                        && i != K - 1) {
                                System.out.println(
                                                "The number is "
                                                                + "greater than " + guess);
                        } else if (number < guess
                                        && i != K - 1) {
                                System.out.println(
                                                "The number is"
                                                                + " less than " + guess);
                        }
                }

                if (i == K) {
                        System.out.println(
                                        "You have exhausted"
                                                        + " K trials.");

                        System.out.println(
                                        "The number was " + number);
                }
        }

        public static void main(String arg[]) {

                // Function Call
                guessingNumberGame();
        }
}

/*
 * output
 * A number is chosen between 1 to 100.Guess what the number is chosen? within 5
 * trials.
 * Guess the number:
 * 45
 * The number is greater than 45
 * Guess the number:
 * 55
 * The number is greater than 55
 * Guess the number:
 * 60
 * The number is greater than 60
 * Guess the number:
 * 70
 * The number is greater than 70
 * Guess the number:
 * 80
 * You have exhausted K trials.
 * The number was 75
 * 
 * A number is chosen between 1 to 100.Guess what the number is chosen? within 5
 * trials.
 * Guess the number:
 * 19
 * The number is greater than 19
 * Guess the number:
 * 29
 * The number is less than 29
 * Guess the number:
 * 27
 * The number is less than 27
 * Guess the number:
 * 25
 * Congratulations! You guessed the number.
 */