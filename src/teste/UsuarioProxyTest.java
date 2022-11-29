package teste;

import main.BD;
import main.Funcionario;
import main.Usuario;
import main.UsuarioProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioProxyTest {

    @BeforeEach
    void setUp() {
        BD.addUsuario(new Usuario(123,"JJr","Madeira",120));
        BD.addUsuario(new Usuario(124,"J","Madeira",150));
    }

    @Test
    void deveObterDadosPessoais() {
        UsuarioProxy usuario = new UsuarioProxy(124);

        assertEquals(Arrays.asList("J", "Madeira"), usuario.obterDadosPessoais());
    }

    @Test
    void deveObterSalario() {
        Funcionario funcionario = new Funcionario("Ana", false);
        UsuarioProxy aluno = new UsuarioProxy(123);

        assertEquals(120, aluno.obterSalario(funcionario));
    }

    @Test
    void deveSetarSalario() {
        Funcionario funcionario = new Funcionario("Ana", true);
        UsuarioProxy aluno = new UsuarioProxy(123);

        assertEquals("Seu salario foi modificado por: Ana", aluno.setSalario(125, funcionario));
    }

    @Test
    void deveRetornarUsuarioNaoAltorizado(){
        try {
            Funcionario funcionario = new Funcionario("Ana", false);
            UsuarioProxy aluno = new UsuarioProxy(123);

            aluno.setSalario(125, funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }
}