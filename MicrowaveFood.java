/*
 * This program calculates the time needed to heat food.
 *
 * @author  Jenoe Balote
 * @version 1.0
 * @since 2021-11-22
 */

import java.util.Scanner;

/**
 * This class has the calculations necessary for figuring out how much energy
 * would be produced by a specific amount of mass.
 */
public final class MicrowaveFood {
    /**
     * This constant represents the interval of increase at zero percent.
     */
    public static final int ZERO_PERCENT_INCREASE = 1;
    /**
     * This constant represents the interval of increase at fifty percent.
     */
    public static final double FIFTY_PERCENT_INCREASE = 1.5;
    /**
     * This constant represents the interval of increase at one hundred percent.
     */
    public static final int HUNDRED_PERCENT_INCREASE = 2;
    /**
     * This constant represents the time it takes to warm up a sub.
     */
    public static final int SUB_TIME = 60;
    /**
     * This constant represents the time it takes to warm up a pizza.
     */
    public static final int PIZZA_TIME = 45;
    /**
     * This constant represents the time it takes to warm up a soup.
     */
    public static final int SOUP_TIME = 105;
    /**
     * This constant represents the amount of seconds in a minute.
     */
    public static final int SECS_IN_MIN = 60;
    /**
     * This constant defines the number of food choices picked if the user
     * chooses one.
     */
    public static final int ONE = 1;
    /**
     * This constant defines the number of food choices picked if the user
     * chooses two.
     */
    public static final int TWO = 2;
    /**
     * This constant defines the number of food choices picked if the user
     * chooses three.
     */

    public static final int THREE = 3;

    /**
    * This is a constructor.
    */
    private MicrowaveFood() {

    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        // Create new Scanner-type variable
        final Scanner foodInput = new Scanner(System.in);
        final Scanner numberInput = new Scanner(System.in);

        // Variables
        double cookTime = 0;
        float cookTimeMinutes = 0f;
        float cookTimeSeconds = 0f;
        int numOfItems = 0;

        System.out.println("This program shows the total cook time.");
        System.out.print("Are you heating a sub, pizza or soup?: ");

        while (true) {
            // food item input
            final String foodChoice = foodInput.nextLine();

            if ("sub".equals(foodChoice)) {
                // Assigning cooktime for food items
                cookTime = SUB_TIME;
                break;
            } else if ("pizza".equals(foodChoice)) {
                cookTime = PIZZA_TIME;
                break;
            } else if ("soup".equals(foodChoice)) {
                cookTime = SOUP_TIME;
                break;

            } else {
                System.out.println("That's not an option!");
                System.out.print("Are you heating a sub, pizza or soup: ");
                continue;
            }
        }
        // number of items input
        while (true) {

            System.out.print("Enter how many you are heating (1-3): ");

            // check if input is an integer
            while (!numberInput.hasNextInt()) {
                System.out.println("That's not a valid number!");
                System.out.print("How many you are heating (min. 1, max. 3): ");
                // moves scanner until correct value
                numberInput.next();
            }
            numOfItems = numberInput.nextInt();

            // process
            if (numOfItems == ONE) {
                // assigning cooktime for item quantity
                cookTime = cookTime * ZERO_PERCENT_INCREASE;
            } else if (numOfItems == TWO) {
                cookTime = cookTime * FIFTY_PERCENT_INCREASE;
            } else if (numOfItems == THREE) {
                cookTime = cookTime * HUNDRED_PERCENT_INCREASE;
            } else {
                System.out.println("That's not an option! Try again.");
                continue;
            }
            // https://stackoverflow.com/questions/14081864/
            // java-time-minutessecondsmiliseconds
            // calculates seconds
            cookTimeSeconds = (int) cookTime % SECS_IN_MIN;
            // calculates minutes
            cookTimeMinutes = (int) (cookTime / SECS_IN_MIN) % SECS_IN_MIN;
            break;
        }
        // output
        System.out.print("\nThe total cook time is "
                        + String.format("%.0f", cookTimeMinutes)
                        + " minute(s) and " + cookTimeSeconds + " second(s)");
        System.out.println("\n\nDone.");
    }
}
