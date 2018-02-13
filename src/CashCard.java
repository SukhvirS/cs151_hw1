import java.util.Calendar;

public class CashCard {
	private Customer holder;
	private int cardNumber;
	private int expMonth;
	private int expYear;
	
	public CashCard(int number, int expMonth, int expYear){
		cardNumber = number;
		this.expMonth = expMonth;
		this.expYear = expYear;
	}
	
	public int getCardNum(){
		return cardNumber;
	}
	
	public int getCardBankID(){
		return Integer.parseInt(Integer.toString(this.getCardNum()).substring(0,1));
	}

	public boolean isValid(){
		if(this.expYear < Calendar.YEAR){
			return false;
		}
		else if(this.expMonth < (Calendar.MONTH)+1){
			return false;
		}
		else{
			return true;
		}
	}
}
