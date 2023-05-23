import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
    public class choice {

        public void buy_ticket(int[] row1Array, int[] row2Array, int[] row3Array, ArrayList<Ticket> TicketInfo) {
            Scanner scanner = new Scanner(System.in);
            boolean condition = true;
            while (condition)
                try {
                    int row;
                    while (true) {
                        System.out.print("Enter row number (1-3):");
                        row = scanner.nextInt();
                        if (row < 1 || row > 3) {
                            System.out.println("This row number does not exist. Please select 1-3.");
                        } else {
                            break;
                        }
                    }

                    int[] rowArray;
                    switch (row) {              //initialise the empty array to the specific row array according to user input
                        case 1 -> rowArray = row1Array;
                        case 2 -> rowArray = row2Array;
                        case 3 -> rowArray = row3Array;
                        default -> {
                            return;
                        }
                    }

                    int seat;
                    while (true) {
                        if (row == 1) { // added the printing messages to an if condition so that it  changes according to user input
                            System.out.print("Enter seat number (1-12) for row 1:");
                        } else if (row == 2) {
                            System.out.print("Enter seat number (1-16) for row 2:");
                        } else {
                            System.out.print("Enter seat number (1-20) for row 3:");
                        }

                        seat = scanner.nextInt();
                        if (seat < 1 || seat > rowArray.length) { //checks if the seats is within the specific rows boundary
                            System.out.println("Invalid seat number!");
                        } else if (rowArray[seat - 1] == 1) {  //condition to check if its already booked
                            System.out.println("\nSeat " + seat + " in row " + row + " is already booked.\n");
                        } else {
                            //code section to get user details and price and add to arraylist
                            scanner.nextLine();
                            System.out.print("Enter name:");
                            String name = scanner.nextLine();
                            System.out.print("Enter surname:");
                            String surname = scanner.nextLine();
                            System.out.print("Enter email:");
                            String email = scanner.nextLine();
                            int[] prices = {100, 150, 200};
                            int price;

                            while (true) {
                                System.out.print("Enter price " + prices[row - 1] + ":");//gets the index of the prices array
                                price = scanner.nextInt();
                                if (price != prices[row - 1]) {
                                    System.out.println("Invalid price for the relevant row");
                                } else {
                                    break;
                                }
                            }

                            Person newPerson = new Person(name, surname, email);
                            Ticket newTicket = new Ticket(row, seat, price, newPerson);
                            TicketInfo.add(newTicket);
                            rowArray[seat - 1] = 1; //specific index is initialized a value of 1 if bought successfully
                            System.out.println("\nSeat " + seat + " in row " + row + " has been booked successfully.\n");
                            condition = false;
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // consume the invalid input
                }
        }

        public void print_seating_area(int[] rowArray, int leaveSpace) {
            for (int i = 0; i < rowArray.length; i++) {
                if (i == leaveSpace) {
                    // print a space at the half of the array
                    System.out.print("  ");
                }
                if (rowArray[i] == 1) { //if array index is one its printed as x else 0 then printed O
                    System.out.print("X");
                } else {
                    System.out.print("O");
                }
            }
        }

        public void cancel_ticket(int[] row1Array, int[] row2Array, int[] row3Array, ArrayList<Ticket> TicketInfo) {
            Scanner scanner = new Scanner(System.in);
            boolean condition = true;
            int row = 0;
            int[] rowArray = null;

            while (condition) { //condition is true, loops
                try {
                    System.out.print("Enter row number (1-3): ");
                    row = scanner.nextInt();

                    switch (row) { //initialise the empty array to the specific row array according to user input
                        case 1 -> rowArray = row1Array;
                        case 2 -> rowArray = row2Array;
                        case 3 -> rowArray = row3Array;
                        default -> {
                            System.out.println("This row number does not exist. Please select 1-3.");
                            continue; // go back to the start of the loop
                        }
                    }

                    condition = false; // condition is invalid , exit the loop

                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // consume the invalid input
                }
            }

            while (true) {
                System.out.print("Enter seat number: ");
                int seat = scanner.nextInt();
                if (seat < 1 || seat > rowArray.length) {
                    System.out.println("Invalid seat selection.");
                } else if (rowArray[seat - 1] == 0) {
                    System.out.println("\nSeat " + seat + " in row " + row + " is already vacant.\n");
                    break;

                } else {
                    for (int i = 0; i < TicketInfo.size(); i++) {
                        Ticket ticket = TicketInfo.get(i);
                        // Check if the row and seat of the current ticket match the row and seat of the ticket to be cancelled
                        if (ticket.getRow() == row && ticket.getSeat() == seat) {
                            TicketInfo.remove(i); // If there is a match, remove the current ticket from the TicketInfo ArrayList
                            break;
                        }
                    }
                    rowArray[seat - 1] = 0;
                    System.out.println("\nSeat " + seat + " in row " + row + " has been cancelled successfully.\n");
                    break;
                }
            }
        }


        public void show_available(int[] rowArray, String message) {
            System.out.print(message);
            for (int i = 0; i < rowArray.length; i++) {
                if (rowArray[i] == 0) {
                    System.out.print(i + 1 + ", ");
                }
            }
            System.out.println();
        }

        public void save(int[] row1Array, int[] row2Array, int[] row3Array) {
            try {
                // FileWriter object with the filename,  automatically creates a new file or overwrite the existing file
                FileWriter savefile = new FileWriter("row-seatsInfo.txt");
                for (int i : row1Array) {
                    savefile.write(i + " ");
                }
                savefile.write("\n");
                for (int j : row2Array) {
                    savefile.write(j + " ");
                }
                savefile.write("\n");
                for (int k : row3Array) {
                    savefile.write(k + " ");
                }
                savefile.close();
                System.out.println("\nThe data has been saved to the file \n");
            } catch (IOException e) {
                System.out.println("An error occurred while saving the file.");
                e.printStackTrace();
            }
        }
        public void load(int[] row1Array, int[] row2Array, int[] row3Array) {
            try {
                File file=new File("row-seatsInfo.txt");
                Scanner scanner = new Scanner(file);
                // Loop through each element in Array and read the value from the file
                for (int i = 0; i < row1Array.length; i++) {
                    row1Array[i] = Integer.parseInt(scanner.next()); // converts the string content of the file into an integer
                }
                for (int j = 0; j < row2Array.length; j++) {
                    row2Array[j] = Integer.parseInt(scanner.next());
                }
                for (int k = 0; k < row3Array.length; k++) {
                    row3Array[k] = Integer.parseInt(scanner.next());
                }
                scanner.close();
                System.out.println("\nThe data has been loaded from the file \n");
            } catch (IOException e) {
                System.out.println("An error occurred while loading the file.");
                e.printStackTrace();
            }
        }

        public void showTicketsInfo(ArrayList<Ticket> TicketInfo) {
            System.out.println();
            Ticket.print(TicketInfo);
        }
        // Selection Sort method code from lec slide
        public ArrayList<Ticket> sort_tickets (ArrayList<Ticket> TicketInfo) {
            for (int i = 0; i < TicketInfo.size() - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < TicketInfo.size(); j++) {
                    if (TicketInfo.get(j).getPrice() < TicketInfo.get(minIndex).getPrice()) {
                        minIndex = j;
                    }
                }
                Ticket temp = TicketInfo.get(i);
                TicketInfo.set(i, TicketInfo.get(minIndex));
                TicketInfo.set(minIndex, temp);
            }
            // Print sorted tickets information
            System.out.println();
            System.out.println("Sorted Ticket Information:");
            Ticket.print(TicketInfo);

            return TicketInfo;
        }

    }
