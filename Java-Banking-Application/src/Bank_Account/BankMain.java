package Bank_Account;

public class BankMain {

	public static void main(String[] args) {
	
		//Customer Account 1, object
		Account customer1 = new Account();  
        
		//Customer 1 decides to deposit funds
		customer1.deposit(500);
		
		//Customer Account 2, object
		Account customer2 = new Account();
		customer2.withdraw(200);
		
		System.out.print("customer1 has a balance of ");
		System.out.println(customer1.getBalance());
		
		System.out.print("customer2 has a balance of ");
		System.out.println(customer2.getBalance());
	}

}
