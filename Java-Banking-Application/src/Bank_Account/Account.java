package Bank_Account;

public class Account {

	//private because i only want this class to be able to modify the balance
    // if it were public the variable balance would be able to be modified by other classes
	 private double balance;
	 
	 //set balance to 0.00
	 public Account(){
		 balance = 0.00;
		 
	 }
	 
	 //User depositing funds
	 public void deposit(double amount){
		 balance = balance + amount; 
		 
	 }
	 
	 //User withdrawing funds
	 public void withdraw(double amount){
		 if (amount <= balance){
			balance = balance - amount; 
		 }
		 
		 else{
			 System.err.println("Transaction cancelled you have insufficient funds available");
		 }
	 }
	   
	 
	  //User requesting balance
	 public double getBalance(){
		 return balance;
		 
	 }
	 
	 
	 
	 
	 
}
