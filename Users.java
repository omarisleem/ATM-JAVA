import java.util.*;
import java.io.*;
import javax.sound.sampled.Line;

class Users {
    String accNumber;
    String PIN;

    public Users(String accNumber, String PIN) {
        this.accNumber = accNumber;
        this.PIN = PIN;
    }

    public void cleanupTempFile() {
    File tempFile = new File("tempAccounts.txt");
    
    if (tempFile.exists()) {
        if (!tempFile.delete()) {
            tempFile.deleteOnExit();
        }
    }
}


    public void deposit(double DPammount){

        File Mainfile = new File("Accounts.txt");
        File tempFile = new File("tempAccounts.txt");
        boolean found = false;

        try {
            Scanner sc = new Scanner(Mainfile);
            FileWriter writer = new FileWriter(tempFile);

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] parts = line.split(",");
            if (parts[0].equals(accNumber) && parts[2].equals(PIN)) {

                double currentBalance = Double.parseDouble(parts[3]);
                double newBalance = currentBalance + DPammount;

                String newLine = parts[0] + "," + parts[1] + "," + parts[2] + ","+ newBalance;
                found = true;

                writer.write(newLine + "\n");
                
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



    public void withdraw(double withammount){

        File Mainfile = new File("Accounts.txt");
        File tempFile = new File("tempAccounts.txt");
        boolean found = false;
        boolean enough = false;

        try {
            Scanner sc = new Scanner(Mainfile);
            FileWriter writer = new FileWriter(tempFile);

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] parts = line.split(",");

            if (parts[0].equals(accNumber) && parts[2].equals(PIN)) {
                found = true;
                double currentBalance = Double.parseDouble(parts[3]);

                if (currentBalance >= withammount){                
                double newBalance = currentBalance - withammount;
                String newLine = parts[0] + "," + parts[1] + "," + parts[2] + ","+ newBalance;
                
                enough = true;
                writer.write(newLine + "\n");

                }else{
                    System.out.println("Not enough money -_-");
                    writer.write(line + "\n");
                }

                
            }else{
                writer.write(line + "\n");

            }
            }
            sc.close();
            writer.close();
                

        if (found) {
            if (enough) {
                Mainfile.delete();
                tempFile.renameTo(Mainfile);
                System.out.println("Money has been withdrawn successfully ^_^");
            } else {
                tempFile.delete(); 
            }
        } else {
            System.out.println("Account not found or incorrect info ):");
            tempFile.delete(); 
        }
    } catch (IOException e) {
        System.out.println("Error processing file");
        if (tempFile.exists()) {
            tempFile.delete(); 
        }
    }

    cleanupTempFile();  


    }





    public void viewAccount() {
   
            
        try {
            File file = new File("Accounts.txt");
            Scanner sc = new Scanner(file);
            boolean found = false;

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(accNumber) && parts[2].equals(PIN)) {
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