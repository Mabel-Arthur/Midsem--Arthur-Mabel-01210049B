import java.util.Scanner;

public class DistanceConverter {
    public static double metersToKilometers(double meters) {
        return meters / 1000.0;
    }

    public static double kilometersToMeters(double kilometers) {
        return kilometers * 1000.0;
    }

    public static double milesToKilometers(double miles) {
        return miles * 1.60934;
    }

    public static double kilometersToMiles(double kilometers) {
        return kilometers / 1.60934;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Distance Converter");
        System.out.print("Enter distance: ");
        double distance = scanner.nextDouble();
        
        System.out.print("Enter unit to convert from (meters/km/miles): ");
        String fromUnit = scanner.next().toLowerCase();
        
        System.out.print("Enter unit to convert to (meters/km/miles): ");
        String toUnit = scanner.next().toLowerCase();
        
        double convertedDistance = 0;
        
        if (fromUnit.equals("meters") && toUnit.equals("km")) {
            convertedDistance = metersToKilometers(distance);
        } else if (fromUnit.equals("km") && toUnit.equals("meters")) {
            convertedDistance = kilometersToMeters(distance);
        } else if (fromUnit.equals("miles") && toUnit.equals("km")) {
            convertedDistance = milesToKilometers(distance);
        } else if (fromUnit.equals("km") && toUnit.equals("miles")) {
            convertedDistance = kilometersToMiles(distance);
        } else {
            System.out.println("Invalid conversion units! Please enter meters, km, or miles.");
            scanner.close();
            return;
        }
        
        System.out.printf("Converted Distance: %.2f %s\n", convertedDistance, toUnit);
        scanner.close();
    }
}
