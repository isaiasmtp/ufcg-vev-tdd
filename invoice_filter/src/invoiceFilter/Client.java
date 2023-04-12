package invoiceFilter;

public class Client {
	private String name;
	private String state;
	private String date;


	public Client(String name, String state, String date) {
		this.name = name;
		this.state = state;
		this.date = date;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	
}
