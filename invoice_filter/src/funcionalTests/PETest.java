package funcionalTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import invoiceFilter.Client;
import invoiceFilter.Controller;
import invoiceFilter.Invoice;

public class PETest {
	/*
	 * Partição 1
	 * Valores de fatura abaixo de 2000
	 */
	
	@Test
	public void testFilterInvoicesLessThan2000() {
	    // Cenário: invoices com valores menores que 2000
	    Client client1 = new Client("Cliente 1", "SP", "2022-04-10");
	    Invoice invoice1 = new Invoice("1", 1500.0, "2022-04-05", client1);
	    Client client2 = new Client("Cliente 2", "RJ", "2022-03-10");
	    Invoice invoice2 = new Invoice("2", 1900.0, "2022-03-05", client2);
	    ArrayList<Invoice> invoices = new ArrayList<>();
	    invoices.add(invoice1);
	    invoices.add(invoice2);
	    Controller controller = new Controller(invoices);

	    // Ação: filtrar as invoices
	    ArrayList<Invoice> filteredInvoices = controller.filter();

	    // Verificação: apenas as invoices com valores menores que 2000 devem ser retornadas
	    assertEquals(1, filteredInvoices.size());
	    assertTrue(filteredInvoices.contains(invoice1));
	    assertFalse(filteredInvoices.contains(invoice2));
	}

	@Test
	public void testFilterInvoicesEqualTo2000() {
	    // Cenário: invoices com valores iguais a 2000
	    Client client1 = new Client("Cliente 1", "SP", "2022-04-10");
	    Invoice invoice1 = new Invoice("1", 2000.0, "2022-04-05", client1);
	    Client client2 = new Client("Cliente 2", "RJ", "2022-03-10");
	    Invoice invoice2 = new Invoice("2", 2000.0, "2022-03-05", client2);
	    ArrayList<Invoice> invoices = new ArrayList<>();
	    invoices.add(invoice1);
	    invoices.add(invoice2);
	    Controller controller = new Controller(invoices);

	    // Ação: filtrar as invoices
	    ArrayList<Invoice> filteredInvoices = controller.filter();

	    // Verificação: nenhuma invoice deve ser retornada
	    assertEquals(0, filteredInvoices.size());
	}

	@Test
	public void testFilterInvoicesGreaterThan2000() {
	    // Cenário: invoices com valores maiores que 2000
	    Client client1 = new Client("Cliente 1", "SP", "2022-04-10");
	    Invoice invoice1 = new Invoice("1", 2500.0, "2022-04-05", client1);
	    Client client2 = new Client("Cliente 2", "RJ", "2022-03-10");
	    Invoice invoice2 = new Invoice("2", 3000.0, "2022-03-05", client2);
	    ArrayList<Invoice> invoices = new ArrayList<>();
	    invoices.add(invoice1);
	    invoices.add(invoice2);
	    Controller controller = new Controller(invoices);

	    // Ação: filtrar as invoices
	    ArrayList<Invoice> filteredInvoices = controller.filter();

	    // Verificação: nenhuma invoice deve ser retornada
	    assertEquals(0, filteredInvoices.size());
	}
	
	/*
	 * Partição 2
	 *  Valores de fatura entre 2000 e 2500, data até um mês atrás
	 */

	@Test
	public void testInvoiceBetween2000and2500OneMonthAgo() {
	    ArrayList<Invoice> invoices = new ArrayList<>();
	    // Fatura com valor igual a 2000 e data de hoje, espera-se que a fatura não seja filtrada
	    Client client1 = new Client("João", "SP", "2023-05-09");
	    Invoice invoice1 = new Invoice("1", 2000, "2023-05-09", client1);
	    invoices.add(invoice1);
	    
	    // Fatura com valor igual a 2500 e data de um mês atrás, espera-se que a fatura seja filtrada
	    Client client2 = new Client("Maria", "RJ", "2023-04-09");
	    Invoice invoice2 = new Invoice("2", 2500, "2023-04-09", client2);
	    invoices.add(invoice2);

	    Controller controller = new Controller(invoices);
	    ArrayList<Invoice> filteredInvoices = controller.filter();

	    // verificação dos resultados
	    assertFalse(filteredInvoices.contains(invoice1)); // Fatura com valor igual a 2000 e data de hoje, espera-se que a fatura não seja filtrada
	    assertTrue(filteredInvoices.contains(invoice2)); // Fatura com valor igual a 2500 e data de um mês atrás, espera-se que a fatura seja filtrada
	}

	/*
	 * Partição 3
	 *  Valores de fatura entre 2500 e 3000, data de inclusão até 2 meses atrás
	 */
	@Test
	public void testCheckInvoice_Partition3_Case5() {
	    ArrayList<Invoice> invoices = new ArrayList<>();

	    // Fatura com valor igual a 2500, data de inclusão há 1 mês
	    Client client = new Client("João", "SP", "2022-04-09");
	    Invoice invoice = new Invoice("2", 2500, "2022-05-09", client);
	    
	    invoices.add(invoice);
	    Controller controller = new Controller(invoices);

	    assertFalse(controller.checkInvoice(invoice));
	}

	@Test
	public void testCheckInvoice_Partition3_Case6() {
	    ArrayList<Invoice> invoices = new ArrayList<>();

	    Client client = new Client("Maria", "PR", "2022-02-01");
	    Invoice invoice = new Invoice("3", 3000, "2022-05-09", client);
	    
	    invoices.add(invoice);
	    Controller controller = new Controller(invoices);	
	    }
	
	/*
	 * Partição 4
	 *  Valores de fatura acima de 4000, estado da região Sul
	 */
	
	@Test
	public void testInvoiceNotFilteredWithAmount4000AndStatePR() {
		Client client = new Client("John Doe", "PR", "2022-04-10");
		Invoice invoice = new Invoice("001", 4000, "2022-05-09", client);
		ArrayList<Invoice> invoices = new ArrayList<>();
		invoices.add(invoice);
		Controller controller = new Controller(invoices);
		
		ArrayList<Invoice> filteredInvoices = controller.filter();
		
		assertEquals(0, filteredInvoices.size());
	}
	
	@Test
	public void testInvoiceFilteredWithAmount4000AndStateSP() {
		Client client = new Client("John Doe", "SP", "2022-04-10");
		Invoice invoice = new Invoice("001", 4000, "2022-05-09", client);
		ArrayList<Invoice> invoices = new ArrayList<>();
		invoices.add(invoice);
		Controller controller = new Controller(invoices);
		
		ArrayList<Invoice> filteredInvoices = controller.filter();
		
		assertEquals(1, filteredInvoices.size());
		assertEquals(invoice, filteredInvoices.get(0));
	}
	
	@Test
	public void testInvoiceNotFilteredWithAmount5000AndStateRS() {
		// Arrange
		Client client = new Client("John Doe", "RS", "2022-04-10");
		Invoice invoice = new Invoice("001", 5000, "2022-05-09", client);
		ArrayList<Invoice> invoices = new ArrayList<>();
		invoices.add(invoice);
		Controller controller = new Controller(invoices);
		
		ArrayList<Invoice> filteredInvoices = controller.filter();
		
		assertEquals(0, filteredInvoices.size());
	}
	
	@Test
	public void testInvoiceFilteredWithAmount5000AndStateMG() {
		// Arrange
		Client client = new Client("John Doe", "MG", "2022-04-10");
		Invoice invoice = new Invoice("001", 5000, "2022-05-09", client);
		ArrayList<Invoice> invoices = new ArrayList<>();
		invoices.add(invoice);
		Controller controller = new Controller(invoices);
		
		// Act
		ArrayList<Invoice> filteredInvoices = controller.filter();
		
		// Assert
		assertEquals(1, filteredInvoices.size());
		assertEquals(invoice, filteredInvoices.get(0));
	}

}
