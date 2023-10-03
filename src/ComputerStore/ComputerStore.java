package ComputerStore;

import java.util.Scanner;


public class ComputerStore {
    private static final String PASSWORD = "password";
    private static final int MAX_COMPUTERS = 100; // Maximum number of computers in the store
    private static Computer[] inventory = new Computer[MAX_COMPUTERS];
    private static int numComputers = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Computer Store!");

        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1. Enter new computers (password required)");
            System.out.println("2. Change information of a computer (password required)");
            System.out.println("3. Display all computers by a specific brand");
            System.out.println("4. Display all computers under a certain price");
            System.out.println("5. Quit");

            System.out.print("Please enter your choice > ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    enterNewComputers(scanner);
                    break;
                case 2:
                    changeComputerInformation(scanner);
                    break;
                case 3:
                    displayComputersByBrand(scanner);
                    break;
                case 4:
                    displayComputersUnderPrice(scanner);
                    break;
                case 5:
                    System.out.println("Closing the Computer Store. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void enterNewComputers(Scanner scanner) {
        System.out.print("Enter your password: ");
        String password = scanner.next();

        if (password.equals(PASSWORD)) {
            System.out.print("How many computers do you want to enter? ");
            int numToAdd = scanner.nextInt();

            if (numComputers + numToAdd <= MAX_COMPUTERS) {
                for (int i = 0; i < numToAdd; i++) {
                    System.out.println("Enter details for Computer " + (i + 1) + ":");
                    System.out.print("Brand: ");
                    String brand = scanner.next();
                    System.out.print("Model: ");
                    String model = scanner.next();
                    System.out.print("SN: ");
                    long sn = scanner.nextLong();
                    System.out.print("Price: $");
                    double price = scanner.nextDouble();

                    inventory[numComputers] = new Computer(brand, model, sn, price);
                    numComputers++;
                }
                System.out.println("Computers added successfully.");
            } else {
                System.out.println("Not enough space in the inventory.");
            }
        } else {
            System.out.println("Incorrect password. Please try again.");
        }
    }

    private static void changeComputerInformation(Scanner scanner) {
        System.out.print("Enter your password: ");
        String password = scanner.next();

        if (password.equals(PASSWORD)) {
            System.out.print("Enter the computer number you wish to update: ");
            int computerNumber = scanner.nextInt() - 1;

            if (computerNumber < 0 || computerNumber >= numComputers) {
                System.out.println("Invalid computer number.");
                return;
            }

            Computer computer = inventory[computerNumber];
            System.out.println("Current information of Computer #" + (computerNumber + 1) + ":");
            System.out.println(computer);

            while (true) {
                System.out.println("What information would you like to change?");
                System.out.println("1. Brand");
                System.out.println("2. Model");
                System.out.println("3. SN");
                System.out.println("4. Price");
                System.out.println("5. Quit");

                System.out.print("Enter your choice > ");
                int attributeChoice = scanner.nextInt();

                switch (attributeChoice) {
                    case 1:
                        System.out.print("Enter new brand: ");
                        String newBrand = scanner.next();
                        computer.setBrand(newBrand);
                        break;
                    case 2:
                        System.out.print("Enter new model: ");
                        String newModel = scanner.next();
                        computer.setModel(newModel);
                        break;
                    case 3:
                        System.out.print("Enter new SN: ");
                        long newSN = scanner.nextLong();
                        computer.setSn(newSN);
                        break;
                    case 4:
                        System.out.print("Enter new price: $");
                        double newPrice = scanner.nextDouble();
                        computer.setPrice(newPrice);
                        break;
                    case 5:
                        System.out.println("Changes saved.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }

                System.out.println("Updated information of Computer #" + (computerNumber + 1) + ":");
                System.out.println(computer);
            }
        } else {
            System.out.println("Incorrect password. Please try again.");
        }
    }

    private static void displayComputersByBrand(Scanner scanner) {
        System.out.print("Enter brand name: ");
        String brandToSearch = scanner.next();

        System.out.println("Computers with brand '" + brandToSearch + "':");
        for (int i = 0; i < numComputers; i++) {
            if (inventory[i].getBrand().equalsIgnoreCase(brandToSearch)) {
                System.out.println("Computer #" + (i + 1));
                System.out.println(inventory[i]);
            }
        }
    }

    private static void displayComputersUnderPrice(Scanner scanner) {
        System.out.print("Enter a maximum price: $");
        double maxPrice = scanner.nextDouble();

        System.out.println("Computers under $" + maxPrice + ":");
        for (int i = 0; i < numComputers; i++) {
            if (inventory[i].getPrice() < maxPrice) {
                System.out.println("Computer #" + (i + 1));
                System.out.println(inventory[i]);
            }
        }
    }
}
