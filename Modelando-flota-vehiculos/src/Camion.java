public class Camion extends Vehiculo {

    public Camion(String marca, String modelo, int year) {
        super(marca, modelo, year);
    }

    public Camion(String marca, String modelo, int year, double capacidadCarga) {
        super(marca, modelo, year);
        this.capacidadCarga = capacidadCarga;
    }

    private double capacidadCarga;

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public void mover() {
        System.out.println("El Camion avanza lentamente");
    }
}
