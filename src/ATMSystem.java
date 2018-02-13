import java.util.ArrayList;
import java.util.Scanner;


public class ATMSystem {
	
	private String name;
	Bank parentBank;
	private final double MAX_AMOUNT;
	private ArrayList<Customer> customers;
	private int accountNum = 0;
	
	public ATMSystem(String name, Bank parentBank, double maxAmount){
		this.name = name;
		MAX_AMOUNT = maxAmount;
		this.parentBank = parentBank;
		customers = new ArrayList<Customer>();
	}
	
	public void withdraw(CashCard card){
		if(card.isValid() && (card.getCardBankID()==this.parentBank.getBankID())){
			System.out.println("Initiating Authorization");
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter your password: ");
			String inputPass = sc.next();
			if(inputPass )
		}
		else{
			System.out.println("ERROR: Card is expired or BankID does not match");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
