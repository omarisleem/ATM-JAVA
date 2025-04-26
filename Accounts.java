import java.util.*;
import java.io.*;


public class Accounts {
    String UserName;
    String accountNumber;
    String PIN;
    double balance;

    static int accountCount ; 


    public Accounts(String UserName, String PIN, double balance) {
        this.UserName = UserName;
        this.accountNumber = String.valueOf(accountCount++);
        this.PIN = PIN;
        this.balance = balance;
        updateACC_count();
    } 
    
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getUserName() {
        return UserName;
    }
    public String getPIN() {
        return PIN;
    }
    public double getBalance() {
        return balance;
    }


    public String toString() {
        return accountNumber + "," + UserName + "," + PIN + "," + balance;
    }



   public static void getACC_count(){
    try {
        File myfile = new File("accCounter.txt");
        Scanner sc = new Scanner(myfile);

        if(sc.hasNextInt()){
            accountCount = sc.nextInt();
        }
        else{
            accountCount = 10;
        }
        sc.close();

    } catch (Exception e) {
        System.out.println("Error in the file");
        accountCount = 10;
    }
   }



   void updateACC_count(){
        try {
            FileWriter writer = new FileWriter("accCounter.txt");
            writer.write(String.valueOf(accountCount));
            writer.close();
            
        } catch (Exception e) {
            System.out.println("Error in the file");

        }



   }

}
