public class EmpresaApp {
    public static void main(String[] args) {
        // Crear al menos 3 objetos Empleado usando el constructor con todos los atributos
        Empleado empleado1 = new Empleado("Juan Pérez", 101, 25000.0, "Recursos Humanos");
        Empleado empleado2 = new Empleado("María López", 102, 30000.0, "Finanzas");
        Empleado empleado3 = new Empleado("Carlos Sánchez", 103, 28000.0, "Tecnología");

        // Mostrar la información de todos los empleados
        empleado1.mostrarInformacion();
        empleado2.mostrarInformacion();
        empleado3.mostrarInformacion();
        // Modificamos el salario mensual y el departamento del empleado2 usando los setters
        empleado2.setSalarioMensual(32000.0);
        empleado2.setDepartamento("Recursos Humanos");
        // Volver a mostrar la información del empleado2 para ver los cambios
        System.out.println("\nInformación actualizada del empleado2:");
        empleado2.mostrarInformacion();

        // Calcular y mostrar el salario anual
        double salarioAnual = empleado1.calcularSalarioAnual();
        System.out.println("Salario anual: $" + salarioAnual);

        // Intento de acceso directo a un atributo privado (esto causará un error de compilación)
        // System.out.println(empleado1.nombreCompleto);

        // Mostrar la información actualizada
        System.out.println("\nInformación actualizada del empleado:");
        empleado1.mostrarInformacion();
    }

}
