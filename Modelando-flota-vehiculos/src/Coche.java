public class Coche extends Vehiculo implements Arrancable {
    private int numeroPuertas;

    public Coche(String marca, String modelo, int year) {
        super(marca, modelo, year);
    }

    public Coche(String marca, String modelo, int year, int numeroPuertas) {
        super(marca, modelo, year);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public void mover() {
        System.out.println("El coche se mueve por la carretera");
    }

    @Override
    public void arrancar() {
        System.out.println("El coche está arrando con la llave");
    }
}
