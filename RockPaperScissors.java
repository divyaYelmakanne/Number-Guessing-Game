import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Game loop
        while (true) {
            System.out.println("Enter move (rock, paper, scissors). To exit the game, type 'exit':");
            String userMove = scanner.nextLine().toLowerCase();

            // Check if user wants to exit
            if (userMove.equals("exit")) {
                System.out.println("Thanks for playing! Goodbye.");
                break;
            }

            // Validate user input
            if (!userMove.equals("rock") && !userMove.equals("paper") && !userMove.equals("scissors")) {
                System.out.println("Invalid move, please try again.");
                continue;
            }

            // Computer's move (random)
            int randomNumber = random.nextInt(3); // 0, 1, or 2
            String computerMove = "";
            if (randomNumber == 0) {
                computerMove = "rock";
            } else if (randomNumber == 1) {
                computerMove = "paper";
            } else {
                computerMove = "scissors";
            }

            System.out.println("Computer chose: " + computerMove);

            // Determine the winner
            if (userMove.equals(computerMove)) {
                System.out.println("It's a tie!");
            } else if (userMove.equals("rock") && computerMove.equals("scissors")
                    || userMove.equals("paper") && computerMove.equals("rock")
                    || userMove.equals("scissors") && computerMove.equals("paper")) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }
        }

        scanner.close();
    }
}