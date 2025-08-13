/**
 * Sistema de Gestión de Proyectos y Tareas
 * 
 * Este sistema demuestra la implementación de:
 * - Composición: Un proyecto está compuesto por tareas
 * - Cuando se elimina un proyecto, sus tareas se eliminan automáticamente
 * - Límite máximo de tareas por proyecto
 * - Gestión completa del ciclo de vida de proyectos y tareas
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=== SISTEMA DE GESTIÓN DE PROYECTOS Y TAREAS ===\n");

        // Crear el gestor de proyectos
        GestorProyectos gestor = new GestorProyectos();

        // Crear proyectos con diferentes límites de tareas
        System.out.println("1. Creando proyectos...");
        gestor.agregarProyecto("Desarrollo Web", "Sistema de comercio electrónico", 5);
        gestor.agregarProyecto("App Móvil", "Aplicación de gestión de tareas", 3);
        gestor.agregarProyecto("Base de Datos", "Migración de sistema legacy", 8);

        // Agregar tareas a los proyectos
        System.out.println("\n2. Agregando tareas a los proyectos...");

        // Proyecto 1: Desarrollo Web
        Proyecto proyectoWeb = gestor.buscarProyecto("Desarrollo Web").get();
        proyectoWeb.agregarTarea("Diseñar interfaz de usuario");
        proyectoWeb.agregarTarea("Implementar backend con Spring Boot");
        proyectoWeb.agregarTarea("Crear base de datos");
        proyectoWeb.agregarTarea("Implementar autenticación");
        proyectoWeb.agregarTarea("Realizar pruebas de integración");

        // Intentar agregar una tarea más (debería fallar por límite)
        proyectoWeb.agregarTarea("Tarea adicional que no cabe");

        // Proyecto 2: App Móvil
        Proyecto proyectoApp = gestor.buscarProyecto("App Móvil").get();
        proyectoApp.agregarTarea("Diseñar UI/UX");
        proyectoWeb.agregarTarea("Desarrollar funcionalidades core");

        // Proyecto 3: Base de Datos
        Proyecto proyectoDB = gestor.getProyectos().get(2);
        proyectoDB.agregarTarea("Analizar estructura actual");
        proyectoDB.agregarTarea("Diseñar nuevo esquema");
        proyectoDB.agregarTarea("Crear scripts de migración");
        proyectoDB.agregarTarea("Realizar pruebas de migración");

        // Mostrar estado inicial
        System.out.println("\n3. Estado inicial de los proyectos:");
        gestor.mostrarTodosLosProyectos();

        // Marcar algunas tareas como completadas
        System.out.println("\n4. Marcando tareas como completadas...");
        proyectoWeb.marcarTareaCompleta(0); // Diseñar interfaz
        proyectoWeb.marcarTareaCompleta(2); // Crear base de datos
        proyectoApp.marcarTareaCompleta(0); // Diseñar UI/UX
        proyectoDB.marcarTareaCompleta(0); // Analizar estructura actual

        // Marcar algunas tareas como en progreso
        System.out.println("\n5. Marcando tareas como en progreso...");
        proyectoWeb.marcarTareaEnProgreso(1); // Implementar backend
        proyectoDB.marcarTareaEnProgreso(1); // Diseñar nuevo esquema

        // Mostrar estado después de los cambios
        System.out.println("\n6. Estado después de los cambios:");
        gestor.mostrarTodosLosProyectos();

        // Mostrar resumen general
        System.out.println("\n7. Resumen general del sistema:");
        gestor.mostrarResumen();

        // Demostrar la composición: eliminar un proyecto
        System.out.println("\n8. Demostrando composición - Eliminando proyecto 'App Móvil':");
        boolean eliminado = gestor.eliminarProyecto("App Móvil");
        if (eliminado) {
            System.out.println("Proyecto 'App Móvil' eliminado exitosamente.");
            System.out.println("Sus tareas asociadas también se eliminaron automáticamente.");
        }

        // Mostrar estado final
        System.out.println("\n9. Estado final después de la eliminación:");
        gestor.mostrarTodosLosProyectos();
        gestor.mostrarResumen();

        // Demostrar funcionalidades específicas
        System.out.println("\n10. Funcionalidades específicas:");
        System.out.println("--- Mostrando solo las tareas del proyecto 'Desarrollo Web' ---");
        proyectoWeb.mostrarTareas();

        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}
