package br.com.industria.service;

import br.com.industria.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioService {
    public void AplicarAumento(List<Funcionario> funcionarioList, BigDecimal valorDoAumento) {
        for (Funcionario funcionario : funcionarioList) {
            BigDecimal aumento = funcionario.getSalario().multiply(valorDoAumento);
            BigDecimal novoSalario = funcionario.getSalario().add(aumento).setScale(2, RoundingMode.HALF_UP);
            funcionario.setSalario(novoSalario);
        }
    }

    public Map<String, List<Funcionario>> agruparFuncionariosPorFuncao(List<Funcionario> listaFuncionarios) {
        return listaFuncionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public List<Funcionario> filtrarAniversariantesDoMes(List<Funcionario> listaFuncionarios, int mes1, int mes2) {
        return listaFuncionarios.stream()
                .filter(funcionario -> funcionario.getDataNascimento().getMonthValue() == mes1 || funcionario.getDataNascimento().getMonthValue() == mes2)
                .collect(Collectors.toList());
    }

    public Optional<Funcionario> filtrarFuncionarioMaisVelho(List<Funcionario> listaFuncionarios) {
        return listaFuncionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento));
    }

    public List<Funcionario> filtrarPorOrdemAlfabetica(List<Funcionario> listaFuncionarios) {
        return listaFuncionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());
    }

    public BigDecimal somarTotalSalarios(List<Funcionario> listaSalarios) {
        BigDecimal total = BigDecimal.ZERO;
        for (Funcionario funcionario : listaSalarios) {
            total = total.add(funcionario.getSalario());
        }
        return total;
    }
}
