
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        TimeConverter converter = new TimeConverter();
        converter.start();
    }
}


public class TimeConverter {

    // Convert hours to minutes
    public static int hoursToMinutes(int hours) {
        return hours * 60;
    }

    // Convert hours to seconds
    public static int hoursToSeconds(int hours) {
        return hours * 3600;
    }

    // Convert minutes to hours
    public static double minutesToHours(int minutes) {
        return minutes / 60.0;
    }

    // Convert seconds to hours
    public static double secondsToHours(int seconds) {
        return seconds / 3600.0;
    }

    // Start the converter application
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTime Converter Menu:");
            System.out.println("1. Hours to Minutes");
            System.out.println("2. Hours to Seconds");
            System.out.println("3. Minutes to Hours");
            System.out.println("4. Seconds to Hours");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear buffer
                continue;
            }

            if (choice == 5) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            System.out.print("Enter value: ");
            int value;
            try {
                value = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear buffer
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println(value + " hours = " + hoursToMinutes(value) + " minutes");
                    break;
                case 2:
                    System.out.println(value + " hours = " + hoursToSeconds(value) + " seconds");
                    break;
                case 3:
                    System.out.println(value + " minutes = " + minutesToHours(value) + " hours");
                    break;
                case 4:
                    System.out.println(value + " seconds = " + secondsToHours(value) + " hours");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}