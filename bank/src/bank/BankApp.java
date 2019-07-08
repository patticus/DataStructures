package bank;

public class BankApp {

	public static void main(String[] args) {
		BankAccount bank1 = new BankAccount(100d);
		BankAccount bank2 = new BankAccount(10000d);
		
		bank1.display();
		bank1.deposit(100d);
		bank1.display();
		bank1.withdrawal(50d);
		bank1.display();
	}

}
