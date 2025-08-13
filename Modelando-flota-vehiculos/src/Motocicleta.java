public class Motocicleta extends Vehiculo implements Arrancable {
    public Motocicleta(String marca, String modelo, int year) {
        super(marca, modelo, year);
    }

    public Motocicleta(String marca, String modelo, int year, int cilindradaMotocicleta) {
        super(marca, modelo, year);
        this.cilindradaMotocicleta = cilindradaMotocicleta;
    }

    private int cilindradaMotocicleta;

    public int getCilindradaMotocicleta() {
        return cilindradaMotocicleta;
    }

    public void setCilindradaMotocicleta(int cilindradaMotocicleta) {
        this.cilindradaMotocicleta = cilindradaMotocicleta;
    }

    @Override
    public void mover() {
        System.out.println("La motocicleta está acelerando por la carretera");
    }

    public void arrancar() {
        System.out.println("La motocicleta esta arrancando con el botón de encendido");
    }

}
