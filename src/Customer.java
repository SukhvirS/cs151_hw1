import java.util.HashMap;

public class Customer {
	
	private String name;
	private Bank bank;
	private int accountNumber;
	private int passwordHashCode;
	private CashCard card;
	private double balance;
	
	
	public Customer(String customerName, Bank bank, String pass){
		name = customerName;
		this.bank = bank;
		bank.addCustomer(this);
		this.makeAccount(pass);
		card = new CashCard(Integer.parseInt(this.bank.getBankID() +""+ accountNumber), 01, 2020);
	}
	
	public void makeAccount(String pass){
		accountNumber = this.bank.assignAccountNum();
		passwordHashCode = pass.hashCode();
	}
	
	public int getAccountNum(){
		return accountNumber;
	}
	
	public int getCardNum(){
		return card.getCardNum();
	}
	
	public int getPassHashCode(){
		return passwordHashCode;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void deductFromBalance(int amount){
		balance = balance - amount;
	}
	
	
	public static void main(String[] args){
		Bank bank1 = new Bank(1, "ATM 1a", 50, "ATM 1b", 30);
		
		Customer henry = new Customer("henry", bank1, "password");
		
		Customer mark = new Customer("mark", bank1, "pass");
		
		System.out.println("mark's account num: "+ mark.getAccountNum());
		
		System.out.println(henry.getAccountNum());
		System.out.println(mark.getAccountNum());
		System.out.println(henry.getCardNum());
		System.out.println(mark.getCardNum());
	}
}
