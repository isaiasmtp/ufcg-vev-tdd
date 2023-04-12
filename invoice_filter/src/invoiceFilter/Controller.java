package invoiceFilter;

import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.MONTH;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
	private ArrayList<Invoice> invoices = new ArrayList<>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public Controller(ArrayList<Invoice> invoices) {
		this.invoices = invoices;
	}
	
	static boolean isBeforeMonths(int months, Date aDate) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.add(MONTH, months);
	    return aDate.compareTo(calendar.getTime()) < 0;
	  }
	
	boolean checkDate(int month, String date) {
		try {
			return isBeforeMonths(month, sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}


	boolean checkSouthState(String state) {
		boolean check_state = state.equals("PR") || state.equals("RS") || state.equals("SC"); 
		return check_state;
		
	}
	
	
	boolean checkInvoice(Invoice invoice) {
		boolean check_amount = invoice.getAmount() < 2000;

		boolean check_amount_date = invoice.getAmount() >= 2000 
				&& invoice.getAmount() < 2500 
				&& checkDate(-1, invoice.getDate());
		
		boolean check_amount_client_date = invoice.getAmount() >= 2500 
				&& invoice.getAmount() < 3000 
				&& checkDate(-2, invoice.getClient().getDate());
		
		boolean check_amount_state = invoice.getAmount() >= 4000 
				&& checkSouthState(invoice.getClient().getState());
	
		return check_amount || check_amount_date || check_amount_client_date || check_amount_state;
	}


	public ArrayList<Invoice> filter(){
		ArrayList<Invoice> filteredInvoices = new ArrayList<>();
		for (Invoice invoice : this.invoices) { 		      
			if (!checkInvoice(invoice)){
				filteredInvoices.add(invoice);
			}
		}
		return filteredInvoices;
	}
}
