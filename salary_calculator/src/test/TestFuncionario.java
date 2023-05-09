package test;

import org.junit.Assert;
import org.junit.Test;
import salaryCalculator.Funcionario;

public class TestFuncionario {

    @Test
    public void testGetSalarioBase() {
        Funcionario funcionario = new Funcionario("João", "joao@example.com", 2500, "DESENVOLVEDOR");
        double salarioBase = funcionario.getSalarioBase();
        Assert.assertEquals(2500, salarioBase, 0.01);
    }

    @Test
    public void testGetCargo() {
        Funcionario funcionario = new Funcionario("Maria", "maria@example.com", 3500, "DESENVOLVEDOR");
        String cargo = funcionario.getCargo();
        Assert.assertEquals("DESENVOLVEDOR", cargo);
    }

    @Test
    public void testSetSalarioBase() {
        Funcionario funcionario = new Funcionario("Pedro", "pedro@example.com", 1500, "DBA");
        funcionario.setSalarioBase(2000);
        double salarioBase = funcionario.getSalarioBase();
        Assert.assertEquals(2000, salarioBase, 0.01);
    }

    @Test
    public void testSetCargo() {
        Funcionario funcionario = new Funcionario("Ana", "ana@example.com", 2500, "TESTADOR");
        funcionario.setCargo("ANALISTA");
        String cargo = funcionario.getCargo();
        Assert.assertEquals("ANALISTA", cargo);
    }
}
