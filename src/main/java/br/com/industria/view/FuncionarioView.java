package br.com.industria.view;

import br.com.industria.model.Funcionario;
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
}