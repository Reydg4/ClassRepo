/**
 *
 * @author reyg
 */
import java.util.Scanner;

public class HealthyHearts {
    public static void main(String [] args){
        //objects 
        Scanner sn = new Scanner(System.in);
        
        //variables
        int age = 0;
        boolean isAge = false;
        int maxHeartRate;
        int minHRZone;
        int maxHRZone;
        //will keep asking till a valid age is given
        while(!isAge){
            try{
                System.out.println("What is your age? ");
                age = sn.nextInt();
                isAge = true;
            }catch(Exception e){
                sn.nextLine();
                continue;
            }
        }
        // prints out the required information
        System.out.println("Your maximum heart rate should be " + (220 - age));
        System.out.println(
                //to match the output of the assignment I got rid of doubles/floats
                "Your targe HR Zone is " +
                (int)Math.round(.50 * (220 - age)) + " - " + 
                (int)Math.round(.85 * (220 - age)) + " beats per minute"
        );
    }
}
