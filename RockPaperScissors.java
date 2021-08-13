package com.rg.cumulativeexercises;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author reyg
 */
public class RockPaperScissors {
    public static void main(String [] args){
        //objects
        Scanner sn = new Scanner(System.in);
        Random rn = new Random();
        
        //variables
        boolean game = true;
        int userChoice = 0;
        int computerChoice;
        int userWins = 0;
        int computerWins = 0;
        int ties = 0;
        String response;
        
        //game starts
        System.out.println("Hello! Ready for Rock-Paper-Scissors???");
        while(game){
            int rounds = -1;
            //get input from user as to how many rounds, only +ints allowed
            try{
                System.out.println("How many rounds would you like to play?(Please select between 1-10): ");
                rounds = sn.nextInt();
            }catch(Exception e){
                System.out.println("Not a valid Entry!");
            }
            //rounds must be between 1-10 or else it wont run
            if(rounds < 1 || rounds > 10 || rounds == -1){
                System.out.println("Not a valid Entry!");
                game = false;
            }else{
                // the number entered was valied and the game can start
                // print out the rules for player
                System.out.println("*******Rules!*******");
                System.out.println("Enter 1 for Rock");
                System.out.println("Enter 2 for Paper");
                System.out.println("Enter 3 for Scissors");
                System.out.println("*****GOOD LUCK!*****");
                System.out.println();
                //Run program for however many rounds the player said
                for(int i = 0; i < rounds; i++){
                    boolean notValid = true;
                    // ask for their choice until a valid one is given
                    while(notValid){
                        userChoice = -1;
                        try{
                            System.out.println("Please enter your choice for our battle(Within range of course!): ");
                            userChoice = sn.nextInt();
                            sn.nextLine();
                            if((userChoice > 0) && (userChoice  <= 3)) notValid = false;
                        }catch(Exception e){
                            // nextInt doesn't read \n so gotta take that out or infinite loop
                            sn.nextLine();
                            continue;
                        }
                    }
                    //randomly select rock-paper-scissors for computer
                    computerChoice = rn.nextInt(3) + 1;
                    //Show player what both players picked
                    System.out.println("You picked: " + choice(userChoice));
                    System.out.println("I picked : " + choice(computerChoice));
                    //check for tie
                    if(userChoice == computerChoice){
                        System.out.println("Its a tie!");
                        ties++;
                    }
                    else{
                        // method to find out the winner
                        boolean userWon = Winner(userChoice,computerChoice);
                        if(userWon == true){
                            // 
                            System.out.println("You win this time!");
                            userWins++;
                        }else{
                            System.out.println("I have won now!!");
                            computerWins++;
                        }
                    }
                }
                // print out result information
                System.out.println("*******SCORES*******" + "\n");
                System.out.println("Ties: " + ties);
                System.out.println("Your wins: " + userWins);
                System.out.println("MY WINS: " + computerWins + "\n");
                //declare a winner
                if(ties > userWins || ties > computerWins){
                    System.out.println("We are an even match. WE BOTH WIN!");
                } 
                else if (userWins > computerWins){
                    System.out.println("You have beat me this time. You win.");
                }
                else{
                    System.out.println("I AM THE BEST. BOW BEFORE ME. I WON");
                }
                // ask player if they want a rematch
                System.out.println("Would you like to play again? 'Yes' or 'No': ");
                response = sn.nextLine();
                if(!("yes".equals(response.toLowerCase()))) game = false; 
            }
        }
        System.out.println("\n Thanks for playing! ");
    }
        // helper method to find out the winner
        private static boolean Winner(int p1, int p2){
            boolean won = false;
            // picks what user picked and compares to what computer picked and 
            // return resulting winner
            switch(p1){
                case 1:
                    if(p2 == 2) won = false;
                    else if(p2 == 3) won = true;
                    break;
                case 2:
                    if(p2 == 1) won = true;
                    else if(p2 == 3) won = false;
                case 3:
                    if(p2 == 1) won = false;
                    else if(p2 == 2) won = true;      
            }
            return won;
        }
        // helper method to figure out what each player picked as a string
        // maybe an array would have been better? Oh well.
        private static String choice(int option){
            String picked = "";
            switch(option){
                case 1:
                    picked = "Rock";
                    break;
                case 2:
                    picked = "Paper";
                    break;
                case 3:
                    picked = "Scissors"; 
                    break;
            }
            return picked;   
        }   
    }

