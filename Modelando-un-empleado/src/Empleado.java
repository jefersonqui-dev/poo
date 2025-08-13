public class Empleado {

private String nombreCompleto;
private int idEmpleado;
private double salarioMensual;
private String departamento;

// Constructor 1: inicializa salarioMensual a un valor por defecto (por ejemplo, 0.0)
public Empleado(String nombreCompleto, int idEmpleado, String departamento) {
    this.nombreCompleto = nombreCompleto;
    this.idEmpleado = idEmpleado;
    this.departamento = departamento;
    this.salarioMensual = 0.0;
}

// Constructor 2: inicializa todos los atributos
public Empleado(String nombreCompleto, int idEmpleado, double salarioMensual, String departamento) {
    this.nombreCompleto = nombreCompleto;
    this.idEmpleado = idEmpleado;
    this.salarioMensual = salarioMensual;
    this.departamento = departamento;
}

// Getters
public String getNombreCompleto() {
    return nombreCompleto;
}

public int getIdEmpleado() {
    return idEmpleado;
}

public double getSalarioMensual() {
    return salarioMensual;
}

public String getDepartamento() {
    return departamento;
}

// Setters solo para salarioMensual y departamento
public void setSalarioMensual(double salarioMensual) {
    if (salarioMensual < 0) {
        System.out.println("Error: El salario mensual no puede ser negativo.");
        this.salarioMensual = 0.0;
    } else {
        this.salarioMensual = salarioMensual;
    }
}

public void setDepartamento(String departamento) {
    this.departamento = departamento;
}

// Método para mostrar la información completa del empleado
public void mostrarInformacion() {
    System.out.println("Información del Empleado:");
    System.out.println("Nombre completo: " + getNombreCompleto());
    System.out.println("ID de empleado: " + getIdEmpleado());
    System.out.println("Salario mensual: $" + getSalarioMensual());
    System.out.println("Departamento: " + getDepartamento());
}

// Método para calcular el salario anual
public double calcularSalarioAnual() {
    return this.salarioMensual * 12;
}


}
