import java.util.*;
import java.io.*;



public class main{
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    boolean ATMrun = true;

    while(ATMrun){
        System.out.println("\n===Welcome to our ATM ^_^ ===\n");
        System.out.println("1. Admin");
        System.out.println("2. User");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");

        String choice = input.nextLine();

        switch (choice) {
            case "1":
                AdminUI.main(args);
                break;
            case "2":
                UserUI.main(args);
                break;
            case "0":
                System.out.println("Bye.");
                ATMrun = false;
                break;
            default:
                System.out.println("-__-");
        }
    }


    }
}