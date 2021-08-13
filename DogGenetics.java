/**
 *
 * @author reyg
 */
import java.util.Scanner;
import java.util.Random;

public class DogGenetics {
    public static void main(String [] args){
        //objects
        Scanner sn = new Scanner(System.in);
        Random rn = new Random();
        //variables
        String dog;
        // ask for dog name and tell about report
        System.out.println("What is your dog's name? ");
        dog = sn.nextLine();
        System.out.println("well then, I have this highly reliable report on " + dog + " prestigious background right here.\n");
        
        System.out.println(dog + " is: \n");
        // prints out dog breads percentages
        genetics();
        
        System.out.println("\nWow, that's QUITE the dog!");
        
        
    }
    private static void genetics(){
        //objects
        Random rn = new Random();
        //vairables
        int remainder = 0;
        int difference = 20;
        int total = 100;
        int percentage;
        int dogsUsed = 0;
        String [] dogs = { "German Sheperd","Siberian Husky","Bulldog","Pug","Poodle","chihuahua","Shiba Inu","Pomeranian"};
        
        //Get 5 dog breeds to loop through
        for( int i = 0; i < 5; i ++){
            //getting a dog and then moving that spacific dog to the last spot
            //that wont be counted in the array. After each loop, the amount of
            //dogs is brought down by 1.
            int spotOfDog = rn.nextInt((dogs.length - 1) - dogsUsed);
            String dogToUse = dogs[spotOfDog];
            dogs[spotOfDog] = dogs[(dogs.length - 1) - dogsUsed];
            dogsUsed++;
            //to randomize and add up to 100, start with 20 and take the difference
            //needed to get to 20 and store it. add this to the 20 needed for 
            //the next loop. etc.
            percentage = rn.nextInt(difference) + 1; 
            remainder += percentage;
            difference = (difference - percentage) + 20;
            total -= percentage;
            
            //when on last dog just add up whatever it takes to get to 100
            if( i == 4 ) percentage += (100 - remainder);
            // percentage of selected dog
            System.out.println(percentage + "% " + dogToUse);
        }
        
        
        
    }
}
