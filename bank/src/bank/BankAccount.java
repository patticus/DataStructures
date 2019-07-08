package bank;

public class BankAccount {
	
	private double balance;
	
	public BankAccount(double openingBalance) {
		this.balance = openingBalance;
		
	}
	
	public void deposit (double amount) {
		this.balance = this.balance + amount;
		
	}
	
	public void withdrawal (double amount) {
		this.balance = this.balance - amount;
	}
	
	public void display () {
		System.out.println("Balance = $"+ this.balance);
	}

}
