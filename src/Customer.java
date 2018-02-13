import java.util.HashMap;

public class Customer {
	
	private String name;
	private Bank bank;
	private int accountNumber;
	private String password;
	private CashCard card;
	//private HashMap<Double, Double> accountNumToCashCard;
	
	public Customer(String customerName, Bank bank){
		name = customerName;
		this.bank = bank;
		bank.addCustomer(this);
		card = new CashCard(Integer.parseInt(this.bank.getBankID() +""+ accountNumber), 01, 2020);
	}
	
	public void makeAccount(String pass){
		accountNumber = this.bank.assignAccountNum();
		password = pass;
	}
	
	public int getAccountNum(){
		return accountNumber;
	}
	
	public int getCardNum(){
		return card.getCardNum();
	}
	
	
	public static void main(String[] args){
		Bank bank1 = new Bank(1, "ATM 1a", 50, "ATM 1b", 30);
		Customer henry = new Customer("henry", bank1);
		henry.makeAccount("password");
		Customer mark = new Customer("mark", bank1);
		System.out.println(henry.getAccountNum());
		System.out.println(mark.getAccountNum());
	}
	

}
