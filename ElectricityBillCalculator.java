import java.util.Scanner;

class Consumer {
    private int consumerNo;
    private String consumerName;
    private int previousReading;
    private int currentReading;
    private String connectionType;

    public Consumer(int consumerNo, String consumerName, int previousReading, int currentReading, String connectionType) {
        this.consumerNo = consumerNo;
        this.consumerName = consumerName;
        this.previousReading = previousReading;
        this.currentReading = currentReading;
        this.connectionType = connectionType;
    }

    public double calculateBill() {
        int unitsConsumed = currentReading - previousReading;
        double billAmount = 0;

        if (unitsConsumed < 0) {
            System.out.println("Error: Current reading cannot be less than previous reading.");
            return -1;
        }

        if (connectionType.equalsIgnoreCase("domestic")) {
            if (unitsConsumed <= 100) {
                billAmount = unitsConsumed * 1.0;
            } else if (unitsConsumed <= 200) {
                billAmount = (100 * 1.0) + ((unitsConsumed - 100) * 2.5);
            } else if (unitsConsumed <= 500) {
                billAmount = (100 * 1.0) + (100 * 2.5) + ((unitsConsumed - 200) * 4.0);
            } else {
                billAmount = (100 * 1.0) + (100 * 2.5) + (300 * 4.0) + ((unitsConsumed - 500) * 6.0);
            }
        } else if (connectionType.equalsIgnoreCase("commercial")) {
            if (unitsConsumed <= 100) {
                billAmount = unitsConsumed * 2.0;
            } else if (unitsConsumed <= 200) {
                billAmount = (100 * 2.0) + ((unitsConsumed - 100) * 4.5);
            } else if (unitsConsumed <= 500) {
                billAmount = (100 * 2.0) + (100 * 4.5) + ((unitsConsumed - 200) * 6.0);
            } else {
                billAmount = (100 * 2.0) + (100 * 4.5) + (300 * 6.0) + ((unitsConsumed - 500) * 7.0);
            }
        } else {
            System.out.println("Invalid connection type! Please enter 'Domestic' or 'Commercial'.");
            return -1;
        }

        return billAmount;
    }

    public void displayBill() {
        double billAmount = calculateBill();
        if (billAmount != -1) {
            System.out.println("\n-------------------- Electricity Bill --------------------");
            System.out.println("Consumer No    : " + consumerNo);
            System.out.println("Consumer Name  : " + consumerName);
            System.out.println("Units Consumed : " + (currentReading - previousReading));
            System.out.println("Bill Amount    : GH " + String.format("%.2f", billAmount));
            System.out.println("---------------------------------------------------------");
        }
    }
}

public class ElectricityBillCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Consumer Number: ");
            int consumerNo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Consumer Name: ");
            String consumerName = scanner.nextLine();

            int previousReading, currentReading;
            while (true) {
                System.out.print("Enter Previous Month Reading: ");
                previousReading = scanner.nextInt();

                System.out.print("Enter Current Month Reading: ");
                currentReading = scanner.nextInt();
                scanner.nextLine();

                if (currentReading >= previousReading) {
                    break;
                } else {
                    System.out.println("Error: Current reading cannot be less than previous reading. Please re-enter.");
                }
            }

            String connectionType;
            while (true) {
                System.out.print("Enter Connection Type (Domestic/Commercial): ");
                connectionType = scanner.nextLine().trim().toLowerCase();

                if (connectionType.equals("domestic") || connectionType.equals("commercial")) {
                    break;
                } else {
                    System.out.println("Invalid connection type! Please enter 'Domestic' or 'Commercial'.");
                }
            }

            Consumer consumer = new Consumer(consumerNo, consumerName, previousReading, currentReading, connectionType);
            consumer.displayBill();

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter correct values.");
        } finally {
            scanner.close();
        }
    }
}
