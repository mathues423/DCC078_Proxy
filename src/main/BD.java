package main;

import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Usuario> usuarios = new HashMap<>();

    public static Usuario getUsuario(Integer ID) {
        return usuarios.get(ID);
    }

    public static void addUsuario(Usuario usuario) {
        usuarios.put(usuario.getID(), usuario);
    }
}
