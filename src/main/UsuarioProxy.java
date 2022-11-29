package main;

import java.util.List;

public class UsuarioProxy implements IUsuario{
    private Usuario usuario;

    private Integer ID;

    public UsuarioProxy(Integer ID) {
        this.ID = ID;
    }

    @Override
    public List<String> obterDadosPessoais() {
        if (this.usuario == null) {
            this.usuario = new Usuario(this.ID);
        }
        return this.usuario.obterDadosPessoais();
    }

    @Override
    public double obterSalario(Funcionario funcionario) {
        if (this.usuario == null) {
            this.usuario = new Usuario(this.ID);
        }
        return this.usuario.obterSalario(funcionario);
    }

    @Override
    public String setSalario(double valor, Funcionario funcionario) {
        if (!funcionario.isAdministrador()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if (this.usuario == null) {
            this.usuario = new Usuario(this.ID);
        }
        return this.usuario.setSalario(valor, funcionario);
    }
}
