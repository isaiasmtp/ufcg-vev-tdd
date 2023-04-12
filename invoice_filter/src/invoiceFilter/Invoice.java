package invoiceFilter;

public class Invoice {
	private String id;
	private double amount;
	private String date;
	private Client client;


	public String getId() {
		return id;
	}


	public double getAmount() {
		return amount;
	}


	public String getDate() {
		return date;
	}
	
	public Client getClient() {
		return client;
	}


	public Invoice(String id, double amount, String date, Client client) {
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.client = client;
	}
}
