package com.tecsup.labs;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de registro de usuarios que maneja la lógica de negocio.
 * Incluye validaciones y almacenamiento simulado.
 */
public final class UserRegistrationService {

    /**
     * Almacena el último mensaje de error generado.
     */
    private String lastErrorMessage = "";

    /**
     * Lista para almacenar los usuarios registrados.
     */
    private List users = new ArrayList();

    /**
     * Longitud mínima requerida para la contraseña.
     */
    private static final int MIN_PASSWORD_LENGTH = 8;

    /**
     * Constructor por defecto.
     * Inicializa la lista de usuarios si es necesario.
     */
    public UserRegistrationService() {
        System.out.println("Constructor llamado");
        if (users == null) {
            users = new ArrayList();
        }
    }

    /**
     * Obtiene el último mensaje de error registrado.
     *
     * @return El mensaje de error.
     */
    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param username El nombre de usuario.
     * @param password La contraseña del usuario.
     * @param email El correo electrónico del usuario.
     * @return true si el registro fue exitoso, false si hubo errores.
     */
    public boolean registerUser(final String username,
                                final String password,
                                final String email) {
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

    /**
     * Simula el guardado del usuario en la base de datos (lista).
     *
     * @param username Nombre de usuario.
     * @param password Contraseña.
     * @param email Email.
     * @throws Exception Si el usuario no es permitido.
     */
    private void saveUser(final String username,
                          final String password,
                          final String email) throws Exception {
        users.add(username);
        if (username.equals("error")) {
            throw new Exception("Nombre de usuario no permitido.");
        }
    }

    /**
     * Método de utilidad experimental.
     *
     * @param s Cadena de entrada.
     * @return Longitud procesada.
     */
    public int x(final String s) {
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