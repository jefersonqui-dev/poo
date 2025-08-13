public class Vehiculo {
    private String marca;
    private String modelo;
    private int year;
    // cosntructot

    public Vehiculo(String marca, String modelo, int year) {
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getYear() {
        return this.year;
    }

    // Método para mostrar la información del vehículo
    public void mostrarInformacion() {
        System.out.println("Información del vehículo:");
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Año: " + this.year);
    }

    public void mover() {
        System.out.println("El vehículo se está moviendo");
    }
}
