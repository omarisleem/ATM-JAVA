public class Accounts {
    String UserName;
    String accountNumber;
    String PIN;
    double balance;


    public Accounts(String UserName, String accountNumber, String PIN, double balance) {
        this.UserName = UserName;
        this.accountNumber = accountNumber;
        this.PIN = PIN;
        this.balance = balance;
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
        return accountNumber + " ," + UserName + " ," + PIN + " ," + balance;
    }

   

}