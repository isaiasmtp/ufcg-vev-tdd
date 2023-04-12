package invoiceFilter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Calendar.MONTH;

import org.junit.Test;

public class ControllerTest {

	@Test
	public void test_check_date() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Client client = new Client("isaias", "SC", "2023-01-01");
		Invoice invoice = new Invoice("1", 1000, "2023-01-01", client);
		
		ArrayList<Invoice> invoices = new ArrayList<>();
		invoices.add(invoice);
		
		Controller controller = new Controller(invoices);
		
		assert controller.isBeforeMonths(-1, sdf.parse("2023-01-01")) == true;
		
		assert controller.checkDate(-1, "2023-01-01") == true;

		assert controller.checkSouthState("PB") == false;
		assert controller.checkSouthState("SC") == true;

		Client client1 = new Client("isaias", "SC", "2023-01-01");
		Invoice invoice1 = new Invoice("1", 1000, "2023-01-01", client1);
		
		assert controller.checkInvoice(invoice1) == true;

		Client client2 = new Client("isaias", "SC", "2023-01-01");
		Invoice invoice2 = new Invoice("2", 2400, "2023-01-01", client2);
		
		assert controller.checkInvoice(invoice2) == true;

		Client client3 = new Client("isaias", "SC", "2023-01-01");
		Invoice invoice3 = new Invoice("3", 2700, "2023-01-01", client3);

		assert controller.checkInvoice(invoice3) == true;

		Client client4 = new Client("isaias", "SC", "2023-01-01");
		Invoice invoice4 = new Invoice("4", 5000, "2023-01-01", client4);
		
		assert controller.checkInvoice(invoice4) == true;

		Client client5 = new Client("isaias", "PB", "2023-01-01");
		Invoice invoice5 = new Invoice("5", 4500, "2023-01-01", client5);
		
		assert controller.checkInvoice(invoice5) == false;
		
		ArrayList<Invoice> invoices_filter = new ArrayList<>();
		invoices_filter.add(invoice1);
		invoices_filter.add(invoice2);
		invoices_filter.add(invoice3);
		invoices_filter.add(invoice4);
		invoices_filter.add(invoice5);
		
		Controller controller1 = new Controller(invoices_filter);
		assert controller1.filter().size() == 1;
	}
}
