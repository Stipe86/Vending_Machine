package vending_machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        System.out.println("\t************************************************");
        System.out.println("\t             WELCOME TO JAVA DRINKS!            ");
        System.out.println("\t************************************************");


        Item [][] items = new Item[][]{
            {new Item("Pepsi",1.99,3), new Item("Fresca", 1.49, 3), new Item("Brisk", 2.49, 3)},
            {new Item ("Fanta", 1.99, 2), new Item("Barq's", 1.49, 2), new Item("A & W", 2.49, 3)},
            {new Item("Crush", 1.99, 2) , new Item("C-Cola", 1.49, 2), new Item("Berry", 2.49, 1)}
        };


        Machine vendingMachine = new Machine(items);

        System.out.println(vendingMachine);

        while (true) {



            System.out.print("\nPick a row(0-2): ");
            int row = scan.nextInt();

            System.out.print("Pick a spot in the row(0-2): ");
            int spot = scan.nextInt();


            if (row >= 0 && row < items.length && spot >= 0 && spot < items[row].length) {
            boolean sold = vendingMachine.dispense(row,spot);
            System.out.println(vendingMachine);

            if (sold) {
                System.out.print("\nEnjoy your "+ vendingMachine.getItem(row,spot).getName()+"! Press 1 to purchase another: ");
            }

            else {
                System.out.print("Sorry, we're out of this item. Press 1 to purchase another: ");
                }
        } else {
            System.out.print("Invalid row or spot, press 1 to try again: ");

        }

            int choise = scan.nextInt();

            if (choise != 1) {
                break;
            }

        }

        scan.close();

    }

}
