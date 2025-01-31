

import java.util.Scanner;

public class CurrencyConverter {
    private static final double USD_TO_GHS = 12.0;  // Example rate
    private static final double EUR_TO_GHS = 13.0;
    private static final double JPY_TO_GHS = 0.08;

    public static double convertToGHS(double amount, String currency) {
        switch (currency.toUpperCase()) {
            case "USD": return amount * USD_TO_GHS;
            case "EUR": return amount * EUR_TO_GHS;
            case "JPY": return amount * JPY_TO_GHS;
        
            default: throw new IllegalArgumentException("Unsupported currency!");
        }
    }

    public static double convertFromGHS(double amount, String currency) {
        switch (currency.toUpperCase()) {
            case "USD": return amount / USD_TO_GHS;
            case "EUR": return amount / EUR_TO_GHS;
            case "JPY": return amount / JPY_TO_GHS;
            default: throw new IllegalArgumentException("Unsupported currency!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Enter currency (USD, EUR, JPY, GHS) to convert from: ");
        String fromCurrency = scanner.nextLine().toUpperCase();
        
        System.out.print("Enter currency (USD, EUR, JPY, GHS) to convert to: ");
        String toCurrency = scanner.nextLine().toUpperCase();
        
        double convertedAmount;
        if (toCurrency.equals("GHS")) {
            convertedAmount = convertToGHS(amount, fromCurrency);
        } else if (fromCurrency.equals("GHS")) {
            convertedAmount = convertFromGHS(amount, toCurrency);
        } else {
            System.out.println("Invalid conversion! One of the currencies must be GHS.");
            scanner.close();
            return;
        }
        
        System.out.printf("Converted Amount: %.2f %s\n", convertedAmount, toCurrency);
        scanner.close();
    }
}

