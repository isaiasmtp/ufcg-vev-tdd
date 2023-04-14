
package invoiceFilter;

public class CalculadoraSalario {
    public double calcularSalarioLiquido(Funcionario funcionario) {
        double desconto;
        if (funcionario.getCargo().equals("DESENVOLVEDOR")) {
            desconto = (funcionario.getSalarioBase() >= 3000) ? 0.2 : 0.1;
        } else if (funcionario.getCargo().equals("DBA") || funcionario.getCargo().equals("TESTADOR")) {
            desconto = (funcionario.getSalarioBase() >= 2000) ? 0.25 : 0.15;
        } else if (funcionario.getCargo().equals("GERENTE")) {
            desconto = (funcionario.getSalarioBase() >= 5000) ? 0.3 : 0.2;
        } else {
            desconto = 0;
        }
        return funcionario.getSalarioBase() * (1 - desconto);
    }
}
