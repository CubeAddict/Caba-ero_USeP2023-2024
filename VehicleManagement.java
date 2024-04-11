import java.util.*;

public class VehicleManagement {
    public static void main(String[] args) {
        
        String regNo, make;
        int yearOfManufacture;
        double value;
        
        Vehicle vehicle = new Vehicle();
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Display a list of vehicle details");
            System.out.println("3. Delete a vehicle");
            System.out.println("4. Sort vehicle list by age");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    // add vehicle here
                    System.out.print("Enter registration number: ");
                    regNo = sc.nextLine();
                    System.out.print("Enter make: ");
                    make = sc.nextLine();
                    System.out.print("Enter year of manufacture: ");
                    yearOfManufacture = sc.nextInt();
                    System.out.print("Enter value: ");
                    value = sc.nextDouble();
                    
                    vehicle = new Vehicle(regNo, make, yearOfManufacture, value);
                    System.out.println("Vehicle added successfully!\n");
                    vehicleList.add(new Vehicle(regNo, make, yearOfManufacture, value));
                    break;
                case 2:
                    // display vehicle list here
                    System.out.println("List of vehicle details: ");
                    for (int i = 0; i < vehicleList.size(); i++) {
                        System.out.println(vehicleList.get(i));
                    }
                    break;
                case 3:
                    // delete vehicle
                    System.out.print("Enter the index of the vehicle to delete: ");
                    int index = sc.nextInt();
                    vehicleList.remove(index-1);
                    System.out.println("Vehicle deleted successfully!\n");
                    break;
                case 4:
                    // sort vehicle list by age
                    int sortChoice;
                    do {
                        System.out.print("Sort menu: " + 
                                         "\n1. Sort by age (ascending)" + 
                                         "\n2. Sort by age (descending)" + 
                                         "\n3. Back to main menu" + 
                                         "\nEnter your choice: ");
                        sortChoice = sc.nextInt();
                        
                        switch (sortChoice) {
                            case 1:
                                System.out.println("List of vehicle details sorted by age (ascending): ");
                                Collections.sort(vehicleList, Comparator.comparingInt(Vehicle::getYearOfManufacture));
                                for (int i = 0; i < vehicleList.size(); i++) {
                                    System.out.println(vehicleList.get(i));
                                }
                                break;
                            case 2:
                                System.out.println("List of vehicle details sorted by age (descending): ");
                                Collections.sort(vehicleList, Comparator.comparingInt(Vehicle::getYearOfManufacture).reversed());
                                for (int i = 0; i < vehicleList.size(); i++) {
                                    System.out.println(vehicleList.get(i));
                                }
                                break;
                            case 3:
                                System.out.println("Returning to main menu...\n");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                        
                    } while (sortChoice != 3);
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }

}