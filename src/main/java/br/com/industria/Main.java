package br.com.industria;

import br.com.industria.model.Funcionario;
import br.com.industria.service.FuncionarioService;
import br.com.industria.view.FuncionarioView;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static br.com.industria.view.FuncionarioView.*;

public class Main {

    public static void main(String[] args) {

        FuncionarioService funcionarioService = new FuncionarioService();

        List<Funcionario> listaFuncionarios = new ArrayList<>(Arrays.asList(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
        ));

        listaFuncionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        imprimirListaFuncionarios("\n--- Lista de Funcionários ---", listaFuncionarios);

        funcionarioService.AplicarAumento(listaFuncionarios, new BigDecimal("0.10"));

        imprimirListaFuncionarios("\n--- Lista de Funcionários com valor do salário atualizado ---", listaFuncionarios);

        Map<String, List<Funcionario>> funcionariosAgrupados = funcionarioService.agruparFuncionariosPorFuncao(listaFuncionarios);
        imprimirFuncionariosAgrupados(funcionariosAgrupados);

        List<Funcionario> aniversariantes = funcionarioService.filtrarAniversariantesDoMes(listaFuncionarios,10,12);
        System.out.printf("\n--- Lista de aniversariantes do mês 10 e mês 12 ---\n");
        FuncionarioView.imprimirFuncionariosAniversariantes(aniversariantes);
    }
}
