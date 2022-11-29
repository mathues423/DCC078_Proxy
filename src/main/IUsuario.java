package main;

import java.util.List;

public interface IUsuario {
    List<String> obterDadosPessoais();

    double obterSalario(Funcionario funcionario);

    String setSalario(double valor, Funcionario funcionario);
}
