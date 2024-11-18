import java.util.Scanner;
public class SafeInput {
    public static String getZeroLenString(Scanner pipe, String prompt) {
        String userInput;
        while (true) {
            System.out.print(prompt + ": ");
            userInput = pipe.nextLine();
            if (userInput.length() == 0) {
                System.out.println("Error: Input cannot be empty. Please try again.");
            } else {
                break;
            }
        }
        return userInput;
    }
    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        boolean done = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                pipe.nextLine();
                System.out.println("You must enter a valid integer!");
            }
        } while (!done);
        return retVal;
    }
    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0;
        boolean done = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                pipe.nextLine();
                System.out.println("You must enter a valid double!");
            }
        } while (!done);
        return retVal;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        boolean done = false;
        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("You must enter a valid integer in range!");
                }
            } else {
                pipe.nextLine();
                System.out.println("You must enter a valid integer!");
            }
        } while (!done);
        return retVal;
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retVal = 0;
        boolean done = false;
        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal < low || retVal > high) {
                    System.out.println("You must enter a valid double in range!");
                } else {
                    done = true;
                }
            } else {
                pipe.nextLine();
                System.out.println("You must enter a valid double!");
            }
        } while (!done);
        return retVal;
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input;
        boolean retVal = false;
        boolean done = false;
        do {
            System.out.print(prompt + " [YyNn]: ");
            input = pipe.nextLine();
            if (input.isEmpty()) {
                System.out.println("You must enter y or n");
            } else if (input.equalsIgnoreCase("Y")) {
                retVal = true;
                done = true;
            } else if (input.equalsIgnoreCase("N")) {
                retVal = false;
                done = true;
            } else {
                System.out.println("You must enter Y or N! Not " + input);
            }
        } while (!done);
        return retVal;
    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String retVal;
        boolean done = false;
        do {
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();
            if (retVal.matches(regEx)) {
                done = true;
            } else {
                System.out.println("You must enter a value that matches pattern " + regEx + "! Not " + retVal);
            }
        } while (!done);
        return retVal;
    }
}
