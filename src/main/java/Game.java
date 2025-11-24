import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    public static void main(String[] args) {

        // Create Scanner for collecting user input.
        Scanner scanner = new Scanner(System.in);

        // Collect character name from user.
        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Your name is " + name + " and your role is a delivery driver.");

        // Start the adventure. 
        printDramaticText("It's your first day on the job! You're a recent hire at NomNom Express.");

        int ordernumber = (int)(Math.random() * 900000) + 100000;

        System.out.println("The order number is " + ordernumber + "."); // prints 7 random digits

        System.out.println("Where the order is coming from: ");
        String place = scanner.nextLine();


        // Roll a d20
        System.out.println("Press Enter to see how many items are in the order."); // sees how far away the order is
        scanner.nextLine();


        int roll = (int)(Math.random() * 20) + 1; // 1-20
        Ascii.drawD20(roll);
        if (roll == 1) { // rolls a 1 it can't be retrieved
            System.out.println("This order does not meet the requirements to be delivered. Now you have to wait longer for the next one");
        }
        else {
            System.out.println("This order is good to be picked up!"); 
        }

        System.out.println("Press enter to see how many minutes away are you from the pickup point?");
        scanner.nextLine();
        int[] badNum = {0,5,6,7,8,10,13,17,16,20,23,26,28,31,33,42,41,49,51,62}; // list of bad numbers to roll
        int roll2 = (int)(Math.random() * 68); // 0-67
        Ascii.drawD20(roll2);
        for (int i = 0; i < badNum.length; i++){
            if (roll2 == badNum[i]){
                System.out.println("Chelsea stole your order! Oh no!?");
                printDramaticText("The boss won't be happy about this...");
            }
        }
        printDramaticText("You had a rough first day and the boss calls you to his office...");
         int roll3 = (int)(Math.random() * 2) + 1;
        System.out.println("Press enter to see if the boss fires you?");
        scanner.nextLine(); 
        Ascii.drawD20(roll3);
        if (roll3 == 2){
            System.out.println("You're fired! Guess you're back to eating ramen for breakfast, lunch, and dinner.");
        }
        else {
            System.out.println("You're off the hook...for now.");
        }
    }
        
    public static void printDramaticText(String text) {
        // Delay in milliseconds
        int delay = 100;

        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) {
                System.err.println("Interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    // Draws a monster and returns an int which represents the difficulty of roll required.
    public static int generateMonster() {
        int r = (int)(Math.random() * 6) + 1;
        if(r == 1 || r == 2 || r == 3) {
            String zombie = Character.toString(0x1F9DF);
            System.out.println("++++++++ " + zombie + " A HORDE OF ZOMBIES " + zombie + " ++++++++");
            System.out.println("+                                        +");
            System.out.println("+           roll required:  8            +");
            System.out.println("+                                        +");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");

            return 8;
        }
        if(r == 4 || r == 5) {
            String mask = Character.toString(0x1F3AD);
            System.out.println("++++++++++ " + mask + " DISGUISED MIMIC " + mask + " +++++++++");
            System.out.println("+                                        +");
            System.out.println("+           roll required:  12           +");
            System.out.println("+                                        +");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");

            return 12;
        }
        if(r == 6) {
            String eye = Character.toString(0x1F441);
            System.out.println("+++++++++++ " + eye +  " EVIL BEHOLDER " + eye + " ++++++++++++");
            System.out.println("+                                        +");
            System.out.println("+           roll required:  18           +");
            System.out.println("+                                        +");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");

            return 18;
        }
        return -1;
    } 
}
