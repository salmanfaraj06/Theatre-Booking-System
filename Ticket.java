import java.util.ArrayList;

public class Ticket  {
    private int row;
    private int seat;
    private int price;
    private Person person;

    public Ticket(int row, int seat, int price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public int getRow() {
        return row;
    }


    public int getSeat() {
        return seat;
    }



    public int getPrice() {
        return price;
    }

    public Person getPerson() {
        return person;
    }

    public static void print(ArrayList<Ticket> TicketInfo){
        int totalPrice = 0;
        System.out.println();
        for (Ticket item:TicketInfo){

            System.out.println("Name: " + item.getPerson().getName() + " " + item.getPerson().getSurname());
            System.out.println("Email: " + item.getPerson().getEmail());
            System.out.println("row number: " + item.getRow());
            System.out.println("seat number: " + item.getSeat());
            System.out.println("price: Rs " + item.getPrice());
            System.out.println();
            totalPrice += item.getPrice();
        }
        System.out.println("Total Price: Rs " + totalPrice);
        System.out.println();
    }
}

