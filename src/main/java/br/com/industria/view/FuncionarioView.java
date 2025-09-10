package br.com.industria.view;

import br.com.industria.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class FuncionarioView {

    public static void imprimirListaFuncionarios(String titulo, List<Funcionario> funcionarios) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.of("pt", "BR"));
        DecimalFormat fs = new DecimalFormat("#,##0.00", dfs);

        System.out.println(titulo);

        for (Funcionario f : funcionarios) {
            String saidaFormatada = String.format(
                    "Nome: %s, Data Nascimento: %s, Salário: R$ %s, Função: %s",
                    f.getNome(),
                    f.getDataNascimento().format(dtf),
                    fs.format(f.getSalario()),
                    f.getFuncao()
            );
            System.out.println(saidaFormatada);
        }
    }

    public static void imprimirFuncionariosAgrupados(Map<String, List<Funcionario>> funcionariosAgrupados) {
        System.out.println("\n--- Lista de funcionário por função ---");
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosAgrupados.entrySet()) {
            System.out.println("Função: " + entry.getKey());
            for (Funcionario f : entry.getValue()) {
                System.out.println("- " + f.getNome());
            }
        }
    }

    public static void imprimirFuncionariosAniversariantes(List<Funcionario> aniversariantes) {
        if (aniversariantes.isEmpty()) {
            System.out.print("Nenhum funcionário faz aniversário nesse mês!\n");
            return;
        }
        for (Funcionario f : aniversariantes) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.printf("Nome: %s, Data Nascimento: %s\n", f.getNome(), dtf.format(f.getDataNascimento()));
        }
    }

    public static void imprimirFuncionarioMaisVelho(Funcionario funcionario, int idade) {
        System.out.println("\n--- Funcionário(a) com Maior Idade ---");
        System.out.println("Nome: " + funcionario.getNome() + ", Idade: " + idade);
    }

    public static void imprimirListaFuncionariosOrgemAlfabetica(List<Funcionario> funcionarios) {
        System.out.println("\n--- Lista de funcionário(a)s em ordem alfabética ---");
        for (Funcionario f : funcionarios) {
            System.out.println("Nome: " + f.getNome());
        }
    }

    public static void imprimirTotalSalarios(BigDecimal totalSalarios) {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.of("pt", "BR"));
        DecimalFormat df = new DecimalFormat("#,##0.00", dfs);

        System.out.println("\n--- Soma total dos salários dos funcionnários ---");
        System.out.println("O valor total dos salários de todos os funcionários é: R$ " + df.format(totalSalarios));
    }

    public static void imprimirSalariosEmSalariosMinimos(List<Funcionario> funcionarios) {
        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        System.out.println("\n--- Quantidade de salários mínimos por funcionário ---");

        for (Funcionario f : funcionarios) {
            BigDecimal quantosSalarios = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.printf("Funcionário: %-10s | Ganha aproximadamente %.2f vezes o valor do salário mínimo.\n", f.getNome(), quantosSalarios);
        }
    }
}