import java.util.ArrayList;
import java.util.Scanner;


public class ATMSystem {
	
	private String name;
	private Bank parentBank;
	private final int MAX_AMOUNT;
	private ArrayList<Customer> customers;
	private int accountNum = 0;
	
	public ATMSystem(String name, Bank parentBank, int maxAmount){
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
			if(inputPass.hashCode() == card.getCardHolder().getPassHashCode()){
				System.out.println("Authorization Accepted");
				System.out.println("Please enter the amount you would like to withdraw: ");
				int customerWithdrawRequest = sc.nextInt();
				if(customerWithdrawRequest <= this.MAX_AMOUNT && customerWithdrawRequest >= 0){
					if(!this.parentBank.withdraw(customerWithdrawRequest, card.getCardHolder())){
						System.out.println("Transaction Failed: Please enter a different amount: ");
						customerWithdrawRequest = sc.nextInt();
						this.parentBank.withdraw(customerWithdrawRequest, card.getCardHolder());
					}
				}
				else{
					System.out.println("The amount requested must be less than the ATM's limit ($"+ this.MAX_AMOUNT+"and greater than 0" );
				}
			}
			else{
				System.out.println("Authorization Rejected");
			}
		}
		else{
			System.out.println("ERROR: Card is expired or BankID does not match");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
