import java.util.*;
import java.io.*;

public class main{
    public static void main(String[] args) {

       Scanner input = new Scanner(System.in);
       Admin admin = new Admin();

       System.out.print("Enter the Admin password: ");
       String enteredADPass = input.nextLine();

       if(!admin.Admicheck(enteredADPass)){
            System.out.println("you are NOT and ADMIN -_-");
            return;
       }

       System.out.println("AYE AYE , Admin");

       int choice;
       boolean run = true;

       while (run) { 

            System.out.println("\n");
            System.out.println("1. Add Account");
            System.out.println("2. View Specifec Account");
            System.out.println("3. View All Accounts");
            System.out.println("4. Delete Account");
            System.out.println("5. Update Account");
            System.out.println("6. Delete All Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(input.nextLine());


            switch (choice) {
                case 1:
                    System.out.print("Enter User Name: ");
                    String name = input.nextLine();
                    System.out.print("Enter Account Number: ");
                    String accNum = input.nextLine();
                    System.out.print("Enter PIN: ");
                    String pin = input.nextLine();
                    System.out.print("Enter Balance: ");
                    double balance = Double.parseDouble(input.nextLine());
                    admin.addAcc(name, accNum, pin, balance);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String viewACC = input.nextLine();
                    admin.viewAccount(viewACC);
                    break;

                case 3:
                    System.out.println("ALL ACCOUNTS: ");
                    admin.viewAccountS();
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String delACC = input.nextLine();
                    admin.deleteAccount(delACC);
                    break;
                case 5:
                    System.out.print("Enter Account Number to Update: ");
                    String accNUM = input.nextLine();
                    System.out.print("Enter New User Name: ");
                    String newName = input.nextLine();
                    System.out.print("Enter New PIN: ");
                    String newPin = input.nextLine();

                    admin.updateAccount(accNUM, newName, newPin);
                    break;

                case 6:
                    admin.deleteAll();
                    break;

                case 7:
                    System.out.println("Thanks for using our ATM!");
                    run = false;

                    break;
                    
                default:
                    System.out.println("Invalid choice, please try again.");

                    
                    
            }
           
       }


    }
}