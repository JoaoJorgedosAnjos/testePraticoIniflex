# Teste Prático - Iniflex

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)

## 📝 Descrição

Este projeto é uma solução em Java para o teste prático proposto pela Projedata Informática. O objetivo é criar um sistema para gerenciar funcionários, aplicando diversas operações de manipulação, consulta e agrupamento de dados, demonstrando boas práticas de programação e organização de código.

---

## ✨ Funcionalidades Implementadas

Abaixo está a lista de requisitos do teste e o status de implementação de cada um:

- [x] **1. Classe Pessoa:** Criada com os atributos `nome` (String) e `dataNascimento` (LocalDate).
- [x] **2. Classe Funcionário:** Estende `Pessoa` e adiciona os atributos `salario` (BigDecimal) e `funcao` (String).
- [x] **3. Classe Principal:** Orquestra as seguintes ações:
- [x] **3.1.** Inserir todos os funcionários da tabela.
- [x] **3.2.** Remover o funcionário "João" da lista.
- [x] **3.3.** Imprimir todos os funcionários com formatação específica para data e valores numéricos.
- [x] **3.4.** Aplicar um aumento de 10% no salário de todos os funcionários.
- [x] **3.5.** Agrupar os funcionários por função em um `Map`.
- [x] **3.6.** Imprimir a lista de funcionários agrupada por função.
- [x] **3.8.** Imprimir os funcionários que fazem aniversário nos meses 10 e 12.
- [ ] **3.9.** Imprimir o funcionário com a maior idade.
- [ ] **3.10.** Imprimir a lista de funcionários por ordem alfabética.
- [ ] **3.11.** Imprimir o total dos salários.
- [ ] **3.12.** Imprimir quantos salários mínimos cada funcionário ganha.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 21 (OpenJDK)
* **Sistema de Build:** Maven
* **IDE:** IntelliJ IDEA
* **Controle de Versão:** Git

---

## 🚀 Como Executar o Projeto

Para executar este projeto, siga os passos abaixo:

1.  **Pré-requisitos:**
    * Ter o JDK 17 ou superior instalado.
    * Ter o Maven instalado.

2.  **Clonar o repositório:**
    ```bash
    git clone https://github.com/JoaoJorgedosAnjos/testePraticoIniflex
    ```

3.  **Navegar para a pasta do projeto:**
    ```bash
    cd testePraticoIniflex
    ```

4.  **Executar a aplicação:**
    O projeto pode ser executado diretamente pela sua IDE (IntelliJ IDEA ou VS Code), localizando e executando o método `main` na classe `br.com.industria.Main`.

    Alternativamente, via Maven pelo terminal:
    ```bash
    mvn compile exec:java -Dexec.mainClass="br.com.industria.Main"
    ```

---

## 👨‍💻 Autor

**João Jorge**

* [LinkedIn](https://www.linkedin.com/in/joaojorgedosanjos/)
* [GitHub](https://github.com/JoaoJorgedosAnjos/)