package salaryCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculadoraSalarioTeste {
	
	@Test
    public void testCalcularSalarioLiquidoDesenvolvedorSalarioMaiorQue3000() {
        Funcionario funcionario = new Funcionario("João", "joao@email.com", 4000, "DESENVOLVEDOR");
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioEsperado = 3200;
        double salarioObtido = calculadora.calcularSalarioLiquido(funcionario);
        assertEquals(salarioEsperado, salarioObtido, 0.001);
    }
    
    @Test
    public void testCalcularSalarioLiquidoDesenvolvedorSalarioMenorQue3000() {
        Funcionario funcionario = new Funcionario("Maria", "maria@email.com", 2000, "DESENVOLVEDOR");
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioEsperado = 1800;
        double salarioObtido = calculadora.calcularSalarioLiquido(funcionario);
        assertEquals(salarioEsperado, salarioObtido, 0.001);
    }
    
    @Test
    public void testCalcularSalarioLiquidoDBASalarioMaiorQue2000() {
        Funcionario funcionario = new Funcionario("José", "jose@email.com", 2500, "DBA");
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioEsperado = 1875;
        double salarioObtido = calculadora.calcularSalarioLiquido(funcionario);
        assertEquals(salarioEsperado, salarioObtido, 0.001);
    }
    
    @Test
    public void testCalcularSalarioLiquidoDBASalarioMenorQue2000() {
        Funcionario funcionario = new Funcionario("Ana", "ana@email.com", 1500, "DBA");
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioEsperado = 1275;
        double salarioObtido = calculadora.calcularSalarioLiquido(funcionario);
        assertEquals(salarioEsperado, salarioObtido, 0.001);
    }
    
}