package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import salaryCalculator.CalculadoraSalario;
import salaryCalculator.Funcionario;

public class TestCalculadoraSalario {
	
	private CalculadoraSalario calculadora = new CalculadoraSalario();

    @Test
    public void testCalcularSalarioLiquidoDesenvolvedorSalarioAbaixoDoLimite() {
        Funcionario funcionario = new Funcionario("João", "joao@example.com", 2500, "DESENVOLVEDOR");
        double salarioLiquido = calculadora.calcularSalarioLiquido(funcionario);
        Assert.assertEquals(2250, salarioLiquido, 0.01);
    }

    @Test
    public void testCalcularSalarioLiquidoDesenvolvedorSalarioAcimaDoLimite() {
        Funcionario funcionario = new Funcionario("Maria", "maria@example.com", 3500, "DESENVOLVEDOR");
        double salarioLiquido = calculadora.calcularSalarioLiquido(funcionario);
        Assert.assertEquals(2800, salarioLiquido, 0.01);
    }
    
    @Test
    public void testCalcularSalarioLiquidoDBASalarioAbaixoDoLimite() {
        Funcionario funcionario = new Funcionario("Pedro", "pedro@example.com", 1500, "DBA");
        double salarioLiquido = calculadora.calcularSalarioLiquido(funcionario);
        Assert.assertEquals(1275, salarioLiquido, 0.01);
    }
    
    @Test
    public void testCalcularSalarioLiquidoDBASalarioAcimaDoLimite() {
        Funcionario funcionario = new Funcionario("Ana", "ana@example.com", 2500, "DBA");
        double salarioLiquido = calculadora.calcularSalarioLiquido(funcionario);
        Assert.assertEquals(1875, salarioLiquido, 0.01);
    }

    @Test
    public void testCalcularSalarioLiquidoTestadorSalarioAbaixoDoLimite() {
        Funcionario funcionario = new Funcionario("Carlos", "carlos@example.com", 1500, "TESTADOR");
        double salarioLiquido = calculadora.calcularSalarioLiquido(funcionario);
        Assert.assertEquals(1275, salarioLiquido, 0.01);
    }
    
    @Test
    public void testCalcularSalarioLiquidoTestadorSalarioAcimaDoLimite() {
        Funcionario funcionario = new Funcionario("Laura", "laura@example.com", 2500, "TESTADOR");
        double salarioLiquido = calculadora.calcularSalarioLiquido(funcionario);
        Assert.assertEquals(1875, salarioLiquido, 0.01);
    }

    @Test
    public void testCalcularSalarioLiquidoGerenteSalarioAbaixoDoLimite() {
        Funcionario funcionario = new Funcionario("Rafael", "rafael@example.com", 4000, "GERENTE");
        double salarioLiquido = calculadora.calcularSalarioLiquido(funcionario);
        Assert.assertEquals(3200, salarioLiquido, 0.01);
    }
    
    @Test
    public void testCalcularSalarioLiquidoGerenteSalarioAcimaDoLimite() {
        Funcionario funcionario = new Funcionario("Sandra", "sandra@example.com", 6000, "GERENTE");
        double salarioLiquido = calculadora.calcularSalarioLiquido(funcionario);
        Assert.assertEquals(4200, salarioLiquido, 0.01);
    }
    
    @Test
    public void testCalcularSalarioLiquidoCargoInvalido() {
        Funcionario funcionario = new Funcionario("Ana", "ana@example.com", 2500, "CARGO_INVALIDO");
        double salarioLiquido = calculadora.calcularSalarioLiquido(funcionario);
        Assert.assertEquals(2500, salarioLiquido, 0.01);
    }

}
