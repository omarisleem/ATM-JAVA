import java.util.*;
import java.io.*;



class Admin {

    static final String adminPass = "231000674";


    public boolean Admicheck(String enterdpass) {
        if(enterdpass.equals(adminPass)) {
            return true;
        } else {
            return false;
        }
    }

    public void addAcc(String UserName, String PIN, double balance) {

            
            Accounts acc = new Accounts(UserName, PIN, balance);
        try {
            FileWriter writer = new FileWriter("Accounts.txt", true);
            writer.write(acc.toString() + "\n");
            writer.close();
            System.out.println("Account added successfully ^_^.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
        

        

    }

    public void viewAccount(String accountNumber) {
   
            ;
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
    

    public void deleteAccount(String accountNumber){

            File Mainfile = new File("Accounts.txt");
            File tempFile = new File("tempAccounts.txt");
            

            try {
                Scanner sc = new Scanner(Mainfile);
                FileWriter writer = new FileWriter(tempFile);
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
                    
                }
                else{
                    System.out.println("Account not found ):");
                }
            

            } catch (IOException e) {
                System.out.println("Error in the file ):");
            }
        }


        public void viewAccountS() { 
            
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
                    System.out.println("\n");
                   
                    }
                
                sc.close();
                
            } catch (IOException e) {
                System.out.println("Error while reading the file ):");
            }
        }

    public void updateAccount(String accountNumber, String newUserName, String newPIN) {

            File Mainfile = new File("Accounts.txt");
            File tempFile = new File("tempAccounts.txt");

            try {
                Scanner sc = new Scanner(Mainfile);
                FileWriter writer = new FileWriter(tempFile);
                boolean found = false;
                while(sc.hasNextLine()){
                    String Line = sc.nextLine();
                    String[] parts = Line.split(",");
                    if(parts[0].equals(accountNumber)){

                    String updatedName = newUserName.isEmpty() ? parts[1] : newUserName;
                    String updatedPin = newPIN.isEmpty() ? parts[2] : newPIN;
                    String updatedBalance = parts[3];
                        String newinfo = accountNumber + "," + updatedName + "," + updatedPin + "," + updatedBalance;
                        writer.write(newinfo + "\n");
                        found = true;
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
                    
                    System.out.println("Account Updated successfully ^_^.");
                }
                else{
                    System.out.println("Account not found ):");
                }


                
            } catch (IOException e) {
                System.out.println("Error in the file ):");


            }

    }


    public void deleteAll(){

        

        try {
            FileWriter delete = new FileWriter("Accounts.txt");
            delete.write("");
            delete.close();

            System.out.println("ALL data have been removed ^_^");
            
        } catch (IOException e) {
            System.out.println("error in the file");
        }



    }







}





    
    
    






    



