import java.util.*;
import java.io.*;



class Admin {

    String adminPass;

    public Admin(String adminPass) {
        this.adminPass = adminPass;
    }

    public boolean Admicheck(String enterdpass) {
        if(enterdpass.equals(this.adminPass)) {
            return true;
        } else {
            return false;
        }
    }

    public void addAcc(String adminPass,String UserName, String accountNumber, String PIN, double balance) {
        
        if(Admicheck(adminPass)) {        
            
            Accounts acc = new Accounts(UserName, accountNumber, PIN, balance);
        try {
            FileWriter writer = new FileWriter("Accounts.txt", true);
            writer.write(acc.toString() + "\n");
            writer.close();
            System.out.println("Account added successfully ^_^.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }

        }

    }

    public void viewAccount(String adminPass, String accountNumber) {
        if(Admicheck(adminPass)) {
            ;
            try {
                File file = new File("Accounts.txt");
                Scanner sc = new Scanner(file);

                while(sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] parts = line.split(",");
                    if (parts[0].equals(accountNumber)) {
                        System.out.println("Account Number: " + parts[0]);
                        System.out.println("User Name: " + parts[1]);
                        System.out.println("PIN: " + parts[2]);
                        System.out.println("Balance: " + parts[3]);
                        break;
                    }
                }
                sc.close();
                System.out.println("Account not found ):");



                
            } catch (IOException e) {
                System.out.println("Error while reading the file ):");
            }
        }
        else {
            System.out.println("you are NOT an ADMIN -_-.");
        }
    }

    public void deleteAccount(String adminPass, String accountNumber ){
        if(Admicheck(adminPass)) {

            File Mainfile = new File("Accounts.txt");
            File tempFile = new File("tempAccounts.txt");
            

            try {
                Scanner sc = new Scanner(Mainfile);
                FileWriter writer = new FileWriter(tempFile, true);
                boolean found = false;
                while(sc.hasNextLine()){
                    String Line = sc.nextLine();
                    String[] parts = Line.split(",");
                    if(parts[0].equals(accountNumber)){
                        found = true;
                        System.out.println("Account deleted successfully ^_^.");
                        continue;
                        
                    }
                    else{
                        writer.write(Line + "\n");
                    }

                }
                sc.close();
                writer.close();

                if(found){
                    Mainfile.delete();
                    tempFile.renameTo(Mainfile);
                    System.out.println("Account deleted successfully ^_^.");
                }
                else{
                    System.out.println("Account not found ):");
                }
            

            } catch (IOException e) {
                System.out.println("Error while reading the file ):");
            }
        }
        else {
            System.out.println("you are NOT an ADMIN -_-.");
        }

    }


    public void viewAccountS(String adminPass) {
        if(Admicheck(adminPass)) {
            
            try {
                File file = new File("Accounts.txt");
                Scanner sc = new Scanner(file);

                while(sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] parts = line.split(",");
                    System.out.println("Account Number: " + parts[0]);
                    System.out.println("User Name: " + parts[1]);
                    System.out.println("PIN: " + parts[2]);
                    System.out.println("Balance: " + parts[3]);
                   
                    }
                
                sc.close();
                
            } catch (IOException e) {
                System.out.println("Error while reading the file ):");
            }
        }
        else {
            System.out.println("you are NOT an ADMIN -_-.");
        }
    }

    public void updateAccount(){

    }









}
    
    
    






    



