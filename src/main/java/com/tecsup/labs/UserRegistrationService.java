package com.tecsup.labs;

import java.util.ArrayList;
import java.util.List;

public class UserRegistrationService {
    // CORRECCIÓN: Ahora es private
    private String lastErrorMessage = "";

    // Mala práctica: lista sin genéricos
    private List users = new ArrayList();
    // Mala práctica: número mágico
    private static final int MIN_PASSWORD_LENGTH = 8;

    public UserRegistrationService() {
        System.out.println("Constructor llamado");
        if (users == null) {
            users = new ArrayList();
        }
    }

    // CORRECCIÓN: Método Getter agregado para acceder al mensaje
    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    public boolean registerUser(String username, String password, String email) {
        if (username.trim().isEmpty()) {
            lastErrorMessage = "El nombre de usuario está vacío.";
            return false;
        }
        if (password == null) {
            lastErrorMessage = "La contraseña es null.";
            return false;
        }
        if (password.length() < MIN_PASSWORD_LENGTH) {
            lastErrorMessage = "La contraseña es muy corta.";
            return false;
        }
        if (password.length() < MIN_PASSWORD_LENGTH) {
            System.out.println("Advertencia: contraseña corta.");
        }
        if (!email.contains("@") && !email.contains(".")) {
            lastErrorMessage = "El correo electrónico no parece válido.";
        }
        try {
            saveUser(username, password, email);
        } catch (Exception e) {
            lastErrorMessage = "Error desconocido al guardar el usuario.";
            return false;
        }
        System.out.println("Usuario registrado: " + username);
        return true;
    }

    private void saveUser(String username, String password, String email) throws Exception {
        users.add(username);
        if (username.equals("error")) {
            throw new Exception("Nombre de usuario no permitido.");
        }
    }

    public int x(String s) {
        if (s == null) {
            return -1;
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result = result + s.charAt(i);
        }
        return result.length();
    }
}