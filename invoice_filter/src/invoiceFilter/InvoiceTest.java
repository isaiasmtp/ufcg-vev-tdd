package invoiceFilter;

import static org.junit.Assert.*;

import org.junit.Test;

public class InvoiceTest {

	@Test
	public void test() {
		Invoice invoice = new Invoice("1", 1000.0, "2022-04-04");
		assert invoice.getAmount() == (1000);
		assert invoice.getId().equals("1");
		assert invoice.getDate().equals("2022-04-04");
	}
}
