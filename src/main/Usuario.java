package main;

import java.util.Arrays;
import java.util.List;

public class Usuario implements IUsuario{

    private Integer ID;
    private String nome;
    private String sobrenome;
    private double salario;

    public Usuario(int ID) {
        this.ID = ID;
        Usuario objeto = BD.getUsuario(ID);
        this.nome = objeto.nome;
        this.sobrenome = objeto.sobrenome;
        this.salario = objeto.salario;
    }

    public Usuario(Integer ID, String nome, String sobrenome, double salario) {
        this.ID = ID;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.salario = salario;
    }
    public Integer getID() {
        return ID;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.sobrenome);
    }

    @Override
    public double obterSalario(Funcionario funcionario) {
        return this.salario;
    }

//    @Override
//    public void setSalario(double valor){
//        this.salario = valor;
//    }

    @Override
    public String setSalario(double valor, Funcionario funcionario) {
        this.salario = valor;
        return "Seu salario foi modificado por: "+ funcionario.getNome();
    }
}
