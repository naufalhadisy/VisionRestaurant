// imported java util
import java.util.*;
import java.util.Scanner;

// Class testOrder
public class TestOrder {
    //main 
    public static void main(String[] args) {
        //Assigned scanner, object, and arraylist
        Scanner input = new Scanner (System.in);
        CustomerOrder co = new CustomerOrder ("VISION CUSTOMER");
        ArrayList<OrderList> OrderData = new ArrayList<OrderList>();

        // Global variable
        int choice;
        char menu;
        String m = "";
        double p = 0.0;
        double total = 0;
        int quantity;
        int addState = 0;

        // do while for menu interface
        do {
            System.out.println("\n******** VISION RESTAURANT ********");
            System.out.println();
            System.out.println(" 1. Menu List");
            System.out.println(" 2. Payment");
            System.out.println(" 3. Order History");
            System.out.println(" 4. Exit");
            System.out.println();
            System.out.print("Please enter your choice (1-4) : ");
            //reading input choice
            choice = input.nextInt();

            //switch choice for available menu
            switch(choice) {
                case 1:
                    System.out.println("\n***** Menu List *****");
                    System.out.println("\nMenu \t\t\t\tPrice");
                    System.out.println("(A) " + Menu.MENU1.getMenuName() + "\t\t" + Menu.MENU1.getPrice());
                    System.out.println("(B) " + Menu.MENU2.getMenuName() + "\t\t" + Menu.MENU2.getPrice());
                    System.out.println("(C) " + Menu.MENU3.getMenuName() + "\t\t" + Menu.MENU3.getPrice());
                    System.out.println("(D) " + Menu.MENU4.getMenuName() + "\t" + Menu.MENU4.getPrice());
                    System.out.println("(E) " + Menu.MENU5.getMenuName() + "\t\t" + Menu.MENU5.getPrice());
                    System.out.println("(F) " + Menu.MENU6.getMenuName() + "\t\t" + Menu.MENU6.getPrice());
                    System.out.println("(G) " + Menu.MENU7.getMenuName() + "\t" + Menu.MENU7.getPrice());

                    //do while reading for choosing menu & quantity
                    do {
                        System.out.print("\nChoose Menu: ");
                        menu = input.next().charAt(0);
                        System.out.print("Quantity: ");
                        quantity = input.nextInt();

                        //switch case for menu input
                        switch (menu) {
                            case 'A' | 'a':
                                m = Menu.MENU1.getMenuName();
                                p = Menu.MENU1.getPrice();
                                break;
                            case 'B' | 'b':
                                m = Menu.MENU2.getMenuName();
                                p = Menu.MENU2.getPrice();
                                break;
                            case 'C' | 'c':
                                m = Menu.MENU3.getMenuName();
                                p = Menu.MENU3.getPrice();
                                break;
                            case 'D' | 'd':
                                m = Menu.MENU4.getMenuName();
                                p = Menu.MENU4.getPrice();
                                break;
                            case 'E' | 'e':
                                m = Menu.MENU5.getMenuName();
                                p = Menu.MENU5.getPrice();
                                break;
                            case 'F' | 'f':
                                m = Menu.MENU6.getMenuName();
                                p = Menu.MENU6.getPrice();
                                break;
                            case 'G' | 'g':
                                m = Menu.MENU7.getMenuName();
                                p = Menu.MENU7.getPrice();
                                break;
                        }

                        // exception handling for the calculation
                        try {
                            OrderData.add(new OrderList(m, p, quantity));
                            p = p * quantity;
                            total += p;
                        } catch (ArithmeticException a) {
                            //System.out.println("**** Invalid number calculation ****");
                        }

                        // exception handling for missinput
                        try {
                            System.out.println("\nDo you want to add another menu ? (1 = Yes / 2 = No)");
                            addState = input.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("\n");
                        }
                    }
                        //showing the current payment
                        while (addState != 2) ;
                        co.currentPayment(total);

                        // resetting orderData if total > balance
                        if (total > co.balance) {
                            OrderData.clear();
                            total = 0;
                        }

                    break;

                case 2:
                    
                    //displaying total payment (inc. TAX)
                    co.displayTotalPayment();

                    break;
                case 3:
                    //Showing order history with condition (total>0), if not, go to else{}
                    if (total > 0.0) {
                        System.out.println("Order History\n");
                        System.out.println("Order Number: " + co.getOrderNum());
                        System.out.println("\nMenu \t\t\t\tPrice \t\tQuantity");
                        for (int i = 0; i < OrderData.size(); i++) {
                            System.out.println((i + 1) + ". " + OrderData.get(i).getMenuName() + " \t\tRM " + OrderData.get(i).getPrice() + " \t\t" + OrderData.get(i).getQuantity());
                        }
                        System.out.println("\n\tTotal : RM " + total);
                    }
                    else {
                        System.out.println("\n***** Order History is Empty *****");
                    }

                    break;
                    
                    //Terminate the program
                case 4:
                    System.out.println("Thank you for ordering from Vision Restaurant");
                    System.exit(0);

                default : System.out.println("Wrong Choice");
            }
        }
        
        // Handling for not stoping the do while until the user choose 4 in the choice
        while(choice != 4);
    }
}

