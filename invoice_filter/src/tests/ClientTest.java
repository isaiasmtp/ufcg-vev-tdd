package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import invoiceFilter.Client;

public class ClientTest {

	@Test
	public void test() {
		Client client = new Client("Isaias","PB","2023-04-12");
		assert client.getName().equals("Isaias");
		assert client.getState().equals("PB");
		assert client.getDate().equals("2023-04-12");

	}
}
