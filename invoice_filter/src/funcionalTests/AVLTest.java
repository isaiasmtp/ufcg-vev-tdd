package funcionalTests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import invoiceFilter.Client;
import invoiceFilter.Controller;
import invoiceFilter.Invoice;

public class AVLTest {
	
	@Test
	public void testCheckAmountLessThan2000() {
		Client client = new Client("Lucas", "SP", "2022-01-01");
		Invoice invoice = new Invoice("1", 1500, "2022-04-01", client);
		Controller controller = new Controller(new ArrayList<Invoice>());
		assertTrue(controller.checkInvoice(invoice));
	}
	
	@Test
	public void testCheckAmountBetween2000And2500AndDateBeforeOneMonth() {
		Client client = new Client("Lucas", "SP", "2022-01-01");
		Invoice invoice = new Invoice("1", 2200, "2022-04-01", client);
		Controller controller = new Controller(new ArrayList<Invoice>());
		assertTrue(controller.checkInvoice(invoice));
	}
	
	@Test
	public void testCheckAmountBetween2500And3000AndClientDateBeforeTwoMonths() {
		Client client = new Client("Lucas", "SP", "2022-01-01");
		Invoice invoice = new Invoice("1", 2600, "2022-04-01", client);
		Controller controller = new Controller(new ArrayList<Invoice>());
		assertTrue(controller.checkInvoice(invoice));
	}
	
	@Test
	public void testCheckAmountGreaterThan4000AndStateInSouthRegion() {
		Client client = new Client("Lucas", "RS", "2022-01-01");
		Invoice invoice = new Invoice("1", 4500, "2022-04-01", client);
		Controller controller = new Controller(new ArrayList<Invoice>());
		assertTrue(controller.checkInvoice(invoice));
	}
	
}
