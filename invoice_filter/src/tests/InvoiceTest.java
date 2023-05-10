package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import invoiceFilter.Client;
import invoiceFilter.Invoice;

public class InvoiceTest {

	@Test
	public void test() {
		Client client = new Client("Isaias","PB","2023-04-12");

		Invoice invoice = new Invoice("1", 1000.0, "2022-04-04", client);
		assert invoice.getAmount() == (1000);
		assert invoice.getId().equals("1");
		assert invoice.getDate().equals("2022-04-04");
		assert invoice.getClient().equals(client);
		assert invoice.getClient().getName().equals(client.getName());

	}
}
