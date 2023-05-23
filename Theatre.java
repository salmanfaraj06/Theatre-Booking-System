import java.util.*;
import java.util.ArrayList; // import the ArrayList class

public class Theatre {
    public static void main(String[] args) {

        ArrayList<Ticket> TicketInfo = new ArrayList<>(); // Create an ArrayList
         int[] row1Array = new int[12];
         int[] row2Array = new int[16];
         int[] row3Array = new int[20];
         choice myChoice = new choice();

        System.out.println("Welcome to the New Theatre");
        System.out.println("-------------------------------------------------");
        int option = -1;
        while (option != 0) {
            System.out.print("Please select an option:");
            System.out.println("\n    1) Buy a ticket");
            System.out.println("    2) Print seating area");
            System.out.println("    3) Cancel ticket");
            System.out.println("    4) List available seats");
            System.out.println("    5) Save to file");
            System.out.println("    6) Load from file");
            System.out.println("    7) Print ticket information and total price");
            System.out.println("    8) Sort tickets by price");
            System.out.println("    0) Quit");
            System.out.println("-------------------------------------------------");

            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Enter option: ");
            option = scanner.nextInt();
            switch (option) {
                case 0:
                    System.out.println("Thank you for using the New Theatre ");
                    System.out.println("-------------------------------------------------");

                    break;
                case 1:
                    myChoice.buy_ticket(row1Array, row2Array, row3Array,TicketInfo);
                    System.out.println("-------------------------------------------------");
                    break;
                case 2:
                    System.out.println();
                    System.out.println("      *********** \n" +
                            "       * STAGE * \n" +
                            "      *********** ");
                    System.out.print("    ");
                    myChoice.print_seating_area(row1Array,6);
                    System.out.println();
                    System.out.print("  ");
                    myChoice.print_seating_area(row2Array,8);
                    System.out.println();
                    myChoice.print_seating_area(row3Array,10);
                    System.out.println();

                    System.out.println("-------------------------------------------------");
                    break;
                case 3:
                    myChoice.cancel_ticket(row1Array, row2Array, row3Array,TicketInfo);
                    System.out.println("-------------------------------------------------");
                    break;
                case 4:
                    myChoice.show_available(row1Array,"available seats in row1 :");
                    myChoice.show_available(row2Array,"available seats in row2 :");
                    myChoice.show_available(row3Array,"available seats in row3 :");

                    System.out.println("-------------------------------------------------");
                    break;
                case 5:
                    myChoice.save(row1Array, row2Array, row3Array);
                    System.out.println("-------------------------------------------------");
                    break;
                case 6:
                    myChoice.load(row1Array, row2Array, row3Array);
                    System.out.println("-------------------------------------------------");
                    break;
                case 7:
                    myChoice.showTicketsInfo(TicketInfo);
                    System.out.println("-------------------------------------------------");
                    break;
                case 8:
                    TicketInfo = myChoice.sort_tickets(TicketInfo);
                    System.out.println("-------------------------------------------------");
                    break;


                default:
                    System.out.println("Invalid option!");
                    break;
            }
                }catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
            }
        }
    }
}
