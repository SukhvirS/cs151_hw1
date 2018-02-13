import java.util.ArrayList;

public class Bank {
	private int bankID;
	public int accountNum = 0;
	private ArrayList<Customer> customers;
	private ATMSystem []atm = new ATMSystem[2];

	
	public Bank(int bankID, String atm1Name, double atm1MaxAmount, String atm2Name, double atm2MaxAmount){
		this.bankID = bankID;
		atm[0] = new ATMSystem(this+"a", this, 50);
		atm[1] = new ATMSystem(this+"b", this, 40);
		customers = new ArrayList<Customer>();
	}
	
	public void addCustomer(Customer customerName){
		customers.add(customerName);
	}
	
	public int assignAccountNum(){
		accountNum += 1;
		return accountNum;
	}
	
	public int getBankID(){
		return bankID;
	}
}
