package invoiceFilter;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientTest {

	@Test
	public void test() {
		Client client = new Client("Isaias","PB","2023-04-12");
		assert client.getName().equals("Isaias");
		client.setName("isaias");
		assert client.getName().equals("isaias");

		assert client.getState().equals("PB");
		client.setState("SC");
		assert client.getState().equals("SC");
		
		assert client.getDate().equals("2023-04-12");
		client.setDate("2022-04-04");
		assert client.getDate().equals("2022-04-04");
	}
}
