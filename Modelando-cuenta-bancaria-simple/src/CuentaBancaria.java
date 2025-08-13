public class CuentaBancaria {
    private String numeroCuenta;
    private String nombreTitular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String nombreTitular) {
        this.numeroCuenta = numeroCuenta;
        this.nombreTitular = nombreTitular;
        this.saldo = 0.0;
    }

    // Constructor que recibe número de cuenta, nombre del titular y saldo inicial
    public CuentaBancaria(String numeroCuenta, String nombreTitular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.nombreTitular = nombreTitular;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public String getNombreTitular() {
        return this.nombreTitular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    // Método para depositar dinero en la cuenta
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            System.out.println("Depósito realizado exitosamente. Nuevo saldo: $" + this.saldo);
        } else {
            System.out.println("La cantidad a depositar debe ser mayor que cero.");
        }
    }

    // Método para retirar dinero de la cuenta
    public void retirar(double cantidad) {
        if (cantidad > 0) {
            if (this.saldo >= cantidad) {
                this.saldo -= cantidad;
                System.out.println("Retiro realizado exitosamente. Nuevo saldo: $" + this.saldo);
            } else {
                System.out.println("Fondos insuficientes para realizar el retiro.");
            }
        } else {
            System.out.println("La cantidad a retirar debe ser mayor que cero.");
        }
    }

    // Método para mostrar la información de la cuenta
    public void mostrarInformacion() {
        System.out.println("Información de la cuenta bancaria:");
        System.out.println("Número de cuenta: " + this.numeroCuenta);
        System.out.println("Nombre del titular: " + this.nombreTitular);
        System.out.println("Saldo actual: $" + this.saldo);
    }
}
