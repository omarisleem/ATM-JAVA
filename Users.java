import java.util.*;
import java.io.*;

class Users {
    String accNumber;
    String PIN;

    public Users(String accNumber, String PIN) {
        this.accNumber = accNumber;
        this.PIN = PIN;
    }

    


    public void deposit(String accNumber, double DPammount){

        File Mainfile = new File("Accounts.txt");
        File tempFile = new File("tempAccounts.txt");
        boolean found = false;

        try {
            Scanner sc = new Scanner(Mainfile);
            FileWriter writer = new FileWriter(tempFile, true);

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] parts = line.split(",");
            if (parts[0].equals(accNumber) && parts[2].equals(PIN)) {

                double currentBalance = Double.parseDouble(parts[3]);
                double newBalance = currentBalance + DPammount;

                String newLine = parts[0] + "," + parts[1] + "," + parts[2] + ","+ newBalance;

                writer.write(newLine + "\n");
                found = true;
            }else{
                writer.write(line + "\n");

            }
            }
            sc.close();
            writer.close();
                

            if(found){ 
                Mainfile.delete();
                tempFile.renameTo(Mainfile);
                    
                System.out.println("money has been deposited ^_^.");
            }
            else{
                System.out.println("Account not found or incorrect info ):");
            }
                
            } catch (IOException e) {
                System.out.println("Error in the file");
            }

    }



  public void withdraw(String accNumber, double wthAmmount){

            File Mainfile = new File("Accounts.txt");
            File tempFile = new File("tempAccounts.txt");
            boolean found = false;

            try {
                Scanner sc = new Scanner(Mainfile);
                FileWriter writer = new FileWriter(tempFile, true);

                while(sc.hasNextLine()){
                    String line = sc.nextLine();
                    String[] parts = line.split(",");
                if (parts[0].equals(accNumber) && parts[2].equals(PIN)) {
                    
                    double currentBalance = Double.parseDouble(parts[3]);

                    if (wthAmmount > currentBalance){
                        System.out.println("not enough money -_-");
                        writer.write(line + "\n");
                        continue;
                    }
                    
                    double newBalance = currentBalance - wthAmmount;

                    String newLine = parts[0] + "," + parts[1] + "," + parts[2] + ","+ newBalance;

                    writer.write(newLine + "\n");
                    found = true;
                }else{
                    writer.write(line + "\n");

                }
                }
                sc.close();
                writer.close();
                

                if(found){ 
                    Mainfile.delete();
                    tempFile.renameTo(Mainfile);
                    
                    System.out.println("money has been withdrawn ^_^.");
                }
                else{
                    System.out.println("Account not found or incorrect info ):");
                }
                
            } catch (IOException e) {
                System.out.println("Error in the file");
            }

    }


    public void viewAccount(String accountNumber) {
   
            
        try {
            File file = new File("Accounts.txt");
            Scanner sc = new Scanner(file);
            boolean found = false;

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(accountNumber)) {
                System.out.println("Account Number: " + parts[0]);
                System.out.println("User Name: " + parts[1]);
                System.out.println("PIN: " + parts[2]);
                System.out.println("Balance: " + parts[3]);
                found = true;
                break;
                }
                    
            }
            sc.close();

            if(!found){
                System.out.println("Account not found ):");
            }
                
                
        } catch (IOException e) {
            System.out.println("Error while reading the file ):");
        }
    }


}