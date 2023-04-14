package invoiceFilter;

import static org.junit.Assert.*;

import org.junit.Test;

public class FuncionarioTeste {

	@Test
    public void testGetSalarioBase() {
        Funcionario funcionario = new Funcionario("João", "joao@email.com", 2000, "Analista");
        double salarioEsperado = 2000;
        double salarioObtido = funcionario.getSalarioBase();
        assertEquals(salarioEsperado, salarioObtido, 0.001);
    }
    
    @Test
    public void testGetCargo() {
        Funcionario funcionario = new Funcionario("Maria", "maria@email.com", 3000, "Gerente");
        String cargoEsperado = "Gerente";
        String cargoObtido = funcionario.getCargo();
        assertEquals(cargoEsperado, cargoObtido);
    }
	
}