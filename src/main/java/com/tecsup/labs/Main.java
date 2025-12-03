package com.tecsup.labs;

public class Main {
    public static void main(String[] args) {
        UserRegistrationService service = new UserRegistrationService();

        // 1. Probamos con contraseña muy corta
        service.registerUser("juan", "123", "juan@correo");
        // CORRECCIÓN: Usamos el getter
        System.out.println("Mensaje: " + service.getLastErrorMessage());

        // 2. Probamos con username null
        try {
            service.registerUser(null, "12345678", "correo-sin-arroba");
        } catch (Exception e) {
            System.out.println("Excepción atrapada en main: " + e.getMessage());
        }
        // CORRECCIÓN: Usamos el getter
        System.out.println("Mensaje: " + service.getLastErrorMessage());

        // 3. Probamos el caso que fuerza una excepción
        service.registerUser("error", "12345678", "error@correo.com");
        // CORRECCIÓN: Usamos el getter
        System.out.println("Mensaje: " + service.getLastErrorMessage());
    }
}