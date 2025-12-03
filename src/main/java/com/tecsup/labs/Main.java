package com.tecsup.labs;

/**
 * Clase principal que ejecuta las pruebas manuales del servicio.
 * Contiene el punto de entrada de la aplicación.
 */
public final class Main {

    /**
     * Constructor privado para evitar la instanciación de esta clase utilitaria.
     */
    private Main() {
        // Evitar instanciación
    }

    /**
     * Método principal de la aplicación.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(final String[] args) {
        UserRegistrationService service = new UserRegistrationService();

        // 1. Probamos con contraseña muy corta
        service.registerUser("juan", "123", "juan@correo");
        System.out.println("Mensaje: " + service.getLastErrorMessage());

        // 2. Probamos con username null
        try {
            service.registerUser(null, "12345678", "correo-sin-arroba");
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
        System.out.println("Mensaje: " + service.getLastErrorMessage());

        // 3. Probamos el caso que fuerza una excepción
        service.registerUser("error", "12345678", "error@correo.com");
        System.out.println("Mensaje: " + service.getLastErrorMessage());
    }
}