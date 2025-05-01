import java.util.*;
import java.io.*;


public class UserUI{

    public static void main(String[] args) {    
    
    Scanner input = new Scanner(System.in);

    System.out.print("Enter Account Number: ");
    String accNumber = input.nextLine();

    System.out.print("Enter PIN: ");
    String pin = input.nextLine();

    Users user = new Users(accNumber, pin);

    boolean run = true;

    while (run) {
        System.out.println("\nUser Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Show Details");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");

        String chioce = input.nextLine();


        switch (chioce) {

            case "1":
                System.out.print("Enter amount to deposit: ");
                double depositAmount = Double.parseDouble(input.nextLine());
                user.deposit(depositAmount);
                break;

            case "2":
                System.out.print("Enter amount to Withdraw: ");
                double withammount = Double.parseDouble(input.nextLine());
                user.withdraw(withammount);
                break;

            case "3":
                System.out.println("Account details: ");
                user.viewAccount();
                user.cleanupTempFile();
                break;

             case "0":
                System.out.println("Thank u for using out ATM");
                run = false;
                break;

            default:
                System.out.println("-__-.");
        }

        
    }
        
    }




}