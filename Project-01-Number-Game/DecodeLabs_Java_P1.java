import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class DecodeLabs_Java_P1 {
    public static void main(String[] args) {
        
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        
        int totalScore = 0;
        int roundCount = 1;
        String playAgain = "yes";
        
        System.out.println("=================================");
        System.out.println("      WELCOME TO NUMBER GAME      ");
        System.out.println("=================================");
        System.out.println("I picked a number between 1 to 100");
        System.out.println("You get 10 tries per round");
        System.out.println("");
        
        while (playAgain.equals("yes") || playAgain.equals("y")) {
            
            System.out.println("\n--- ROUND " + roundCount + " ---");
            
            int secretNumber = rand.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean isWinner = false;
            
            while (attempts < maxAttempts && !isWinner) {
                
                int userGuess = 0;
                boolean isValid = false;
                
                while (!isValid) {
                    try {
                        System.out.print("Guess " + (attempts + 1) + " (1-100): ");
                        userGuess = scan.nextInt();
                        
                        if (userGuess < 1 || userGuess > 100) {
                            System.out.println("Please enter a number between 1 and 100");
                        } else {
                            isValid = true;
                        }
                        
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter numbers only");
                        scan.next();
                    }
                }
                
                attempts++;
                
                if (userGuess == secretNumber) {
                    System.out.println("CORRECT!");
                    System.out.println("You got it in " + attempts + " tries");
                    isWinner = true;
                    
                    if (attempts == 1) {
                        totalScore = totalScore + 15;
                        System.out.println("You earned 15 points - Perfect guess!");
                    } else if (attempts <= 3) {
                        totalScore = totalScore + 10;
                        System.out.println("You earned 10 points - Great job!");
                    } else if (attempts <= 5) {
                        totalScore = totalScore + 7;
                        System.out.println("You earned 7 points - Good!");
                    } else if (attempts <= 7) {
                        totalScore = totalScore + 5;
                        System.out.println("You earned 5 points - Not bad!");
                    } else {
                        totalScore = totalScore + 3;
                        System.out.println("You earned 3 points - Close one!");
                    }
                    
                } else if (userGuess > secretNumber) {
                    System.out.println("TOO HIGH! Try a lower number");
                    
                    if (userGuess - secretNumber <= 5) {
                        System.out.println("(You are very close)");
                    } else if (userGuess - secretNumber <= 10) {
                        System.out.println("(You are getting warm)");
                    } else {
                        System.out.println("(You are far off)");
                    }
                    
                } else {
                    System.out.println("TOO LOW! Try a higher number");
                    
                    if (secretNumber - userGuess <= 5) {
                        System.out.println("(You are very close)");
                    } else if (secretNumber - userGuess <= 10) {
                        System.out.println("(You are getting warm)");
                    } else {
                        System.out.println("(You are far off)");
                    }
                }
            }
            
            if (!isWinner) {
                System.out.println("\n=================================");
                System.out.println("GAME OVER! No attempts remaining");
                System.out.println("The secret number was: " + secretNumber);
                System.out.println("=================================");
            }
            
            System.out.println("\nCurrent Score: " + totalScore);
            
            boolean validResponse = false;
            while (!validResponse) {
                try {
                    System.out.print("\nDo you want to play another round? (yes/no): ");
                    playAgain = scan.next();
                    playAgain = playAgain.toLowerCase();
                    
                    if (playAgain.equals("yes") || playAgain.equals("y") || playAgain.equals("no") || playAgain.equals("n")) {
                        validResponse = true;
                    } else {
                        System.out.println("Please enter 'yes' or 'no'");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input, please enter yes or no");
                    scan.next();
                }
            }
            
            if (playAgain.equals("yes") || playAgain.equals("y")) {
                roundCount++;
            }
        }
        
        System.out.println("\n=================================");
        System.out.println("            GAME SUMMARY           ");
        System.out.println("=================================");
        System.out.println("Total Rounds Played: " + roundCount);
        System.out.println("Final Score: " + totalScore);
        
        if (roundCount > 0) {
            double average = (double) totalScore / roundCount;
            System.out.println("Average Score per Round: " + average);
        }
        
        System.out.println("\n=================================");
        
        if (totalScore >= 50) {
            System.out.println("Final Rating: LEGENDARY GUESSER");
            System.out.println("You are a number game master!");
        } else if (totalScore >= 35) {
            System.out.println("Final Rating: EXPERT GUESSER");
            System.out.println("Excellent performance!");
        } else if (totalScore >= 20) {
            System.out.println("Final Rating: GOOD JOB");
            System.out.println("Keep practicing to become master!");
        } else if (totalScore >= 10) {
            System.out.println("Final Rating: NOT BAD");
            System.out.println("You can do better next time!");
        } else {
            System.out.println("Final Rating: NEED MORE PRACTICE");
            System.out.println("Don't give up, try again!");
        }
        
        System.out.println("\n=================================");
        System.out.println("Thank you for playing!");
        System.out.println("=================================");
        
        scan.close();
    }
}
