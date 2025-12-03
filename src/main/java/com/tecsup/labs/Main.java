package com.tecsup.labs;

public class Main {
    public static void main(String[] args) {
        UserRegistrationService service = new UserRegistrationService();

        // Casos de prueba simples
        // 1. Probamos con contraseña muy corta
        service.registerUser("juan", "123", "juan@correo");
        System.out.println("Mensaje: " + service.lastErrorMessage);

        // 2. Probamos con username null (esto debería fallar o dar error)
        try {
            service.registerUser(null, "12345678", "correo-sin-arroba");
        } catch (Exception e) {
            System.out.println("Excepción atrapada en main: " + e.getMessage());
        }
        System.out.println("Mensaje: " + service.lastErrorMessage);

        // 3. Probamos el caso que fuerza una excepción
        service.registerUser("error", "12345678", "error@correo.com");
        System.out.println("Mensaje: " + service.lastErrorMessage);
    }
}