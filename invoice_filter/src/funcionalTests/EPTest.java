package funcionalTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import invoiceFilter.Client;
import invoiceFilter.Controller;
import invoiceFilter.Invoice;

public class EPTest {

	@Test
	public void testFilterInvoiceAmount1000() {
		Client client = new Client("John", "NY", "2023-03-01");
		Invoice invoice = new Invoice("INV001", 1000, "2023-05-01", client);
		
		Controller controller = new Controller(new ArrayList<Invoice>());
		
		boolean actualResult = controller.checkInvoice(invoice);
		
		assertFalse(actualResult);
	}
	
	@Test
	public void testFilterInvoiceAmount1500() {
		Client client = new Client("John", "NY", "2023-03-01");
		Invoice invoice = new Invoice("INV001", 1500, "2023-05-01", client);
		
		Controller controller = new Controller(new ArrayList<Invoice>());
		
		boolean actualResult = controller.checkInvoice(invoice);
		
		assertFalse(actualResult);
	}
	
	@Test
	public void testFilterInvoiceAmount1999() {
		Client client = new Client("John", "NY", "2023-03-01");
		Invoice invoice = new Invoice("INV001", 1999, "2023-05-01", client);
		
		Controller controller = new Controller(new ArrayList<Invoice>());
		
		boolean actualResult = controller.checkInvoice(invoice);
		
		assertFalse(actualResult);
	}
	
	@Test
	public void testFilterInvoiceAmount2000() {
		Client client = new Client("John", "NY", "2023-03-01");
		Invoice invoice = new Invoice("INV001", 2000, "2023-05-01", client);
		
		Controller controller = new Controller(new ArrayList<Invoice>());
		
		boolean actualResult = controller.checkInvoice(invoice);
		
		assertTrue(actualResult);
	}
	
	@Test
	public void testFilterInvoiceAmount100() {
		Client client = new Client("John", "NY", "2023-03-01");
		Invoice invoice = new Invoice("INV001", 100, "2023-05-01", client);
		
		Controller controller = new Controller(new ArrayList<Invoice>());
		
		boolean actualResult = controller.checkInvoice(invoice);
		
		assertFalse(actualResult);
	}
	
	
	
	
	
	
	@Test
	public void testCheckInvoiceAmountLessThan2000() {
	    Client client = new Client("John", "SP", "2023-04-01");
	    Invoice invoice = new Invoice("001", 1500.0, "2023-05-08", client);
	    Controller controller = new Controller(new ArrayList<>(Arrays.asList(invoice)));

	    boolean result = controller.checkInvoice(invoice);

	    assertTrue(result);
	}

	@Test
	public void testCheckInvoiceAmountBetween2000And2500AndDateLessThanOrEqual1MonthAgo() {
	    Client client = new Client("John", "SP", "2023-04-01");
	    Invoice invoice = new Invoice("001", 2400.0, "2023-04-08", client);
	    Controller controller = new Controller(new ArrayList<>(Arrays.asList(invoice)));

	    boolean result = controller.checkInvoice(invoice);

	    assertTrue(result);
	}

	@Test
	public void testCheckInvoiceAmountBetween2000And2500AndDateGreaterThan1MonthAgo() {
	    Client client = new Client("John", "SP", "2023-03-01");
	    Invoice invoice = new Invoice("001", 2400.0, "2023-04-08", client);
	    Controller controller = new Controller(new ArrayList<>(Arrays.asList(invoice)));

	    boolean result = controller.checkInvoice(invoice);
	    assertTrue(result);
	}

	@Test
	public void testCheckInvoiceAmountBetween2500And3000AndDateGreaterThan2MonthsAgo() {
	    Client client = new Client("John", "SP", "2023-02-01");
	    Invoice invoice = new Invoice("001", 2800.0, "2023-05-08", client);
	    Controller controller = new Controller(new ArrayList<>(Arrays.asList(invoice)));

	    boolean result = controller.checkInvoice(invoice);

	    assertTrue(result);
	}

	@Test
	public void testCheckInvoiceAmountBetween2500And3000AndDateLessThanOrEqual2MonthsAgo() {
	    Client client = new Client("John", "SP", "2023-03-01");
	    Invoice invoice = new Invoice("001", 2800.0, "2023-05-08", client);
	    Controller controller = new Controller(new ArrayList<>(Arrays.asList(invoice)));

	    boolean result = controller.checkInvoice(invoice);

	    assertFalse(result);
	}
	
	
	
	
	
	
	
	@Test
	public void testInvoiceBetween2500And3000AndClientIncluded2MonthsAgo() {
	// Preparação do cenário
	String date = "2023-03-09";
	Client client = new Client("João", "SP", date);
	Invoice invoice = new Invoice("123", 2750.0, "2023-05-09", client);
	ArrayList<Invoice> invoices = new ArrayList<>();
	invoices.add(invoice);
	Controller controller = new Controller(invoices);

	boolean result = controller.checkInvoice(invoice);

	assertTrue(result);
	}

	@Test
	public void testInvoiceBetween2500And3000AndClientIncluded1MonthAgo() {
	String date = "2023-04-09";
	Client client = new Client("João", "SP", date);
	Invoice invoice = new Invoice("123", 2750.0, "2023-05-09", client);
	ArrayList<Invoice> invoices = new ArrayList<>();
	invoices.add(invoice);
	Controller controller = new Controller(invoices);

	boolean result = controller.checkInvoice(invoice);

	assertTrue(result);
	}

	@Test
	public void testInvoiceBetween2500And3000AndClientIncluded3MonthsAgo() {
	String date = "2023-01-09";
	Client client = new Client("João", "SP", date);
	Invoice invoice = new Invoice("123", 2750.0, "2023-05-09", client);
	ArrayList<Invoice> invoices = new ArrayList<>();
	invoices.add(invoice);
	Controller controller = new Controller(invoices);

	boolean result = controller.checkInvoice(invoice);
	assertFalse(result);
	}
	
	
	@Test
	public void testInvoiceSouthRegion() {
		Client client = new Client("John", "RS", "2022-04-30");
		Invoice invoice = new Invoice("001", 4500, "2022-05-01", client);
		Controller controller = new Controller(new ArrayList<>(Arrays.asList(invoice)));
		ArrayList<Invoice> filteredInvoices = controller.filter();
		assertTrue(filteredInvoices.isEmpty());
	}

	@Test
	public void testInvoiceNonSouthRegion() {
		Client client = new Client("Mary", "SP", "2022-04-30");
		Invoice invoice = new Invoice("002", 5000, "2022-05-01", client);
		Controller controller = new Controller(new ArrayList<>(Arrays.asList(invoice)));
		ArrayList<Invoice> filteredInvoices = controller.filter();
		assertFalse(filteredInvoices.isEmpty());
	}
	
}
