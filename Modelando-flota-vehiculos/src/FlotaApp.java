public class FlotaApp {
    public static void main(String[] args) {
        Coche miCoche = new Coche("Toyota", "Corolla", 2022, 4);
        Motocicleta miMoto = new Motocicleta("Suzuki", "AX100", 2015, 200);
        Camion miCamion = new Camion("Volvo", "FH16", 2021, 25000.0);

        // polimorfismo(Sobreescritura por herencia)

        Vehiculo vehiculo1 = miCoche;
        Vehiculo vehiculo2 = miMoto;
        Vehiculo vehiculo3 = miCamion;

        vehiculo1.mostrarInformacion();
        vehiculo1.mover();
        System.out.println("---");
        vehiculo2.mostrarInformacion();
        vehiculo2.mover();
        System.out.println("---");
        vehiculo3.mostrarInformacion();
        vehiculo3.mover();

        // Polimorfismo(interfaces)

        System.out.println("Demostracion de polimorfismo (Arrancable)");
        Arrancable arrancable1 = miCoche;
        Arrancable arrancable2 = miMoto;

        arrancable1.arrancar();
        arrancable2.arrancar();

    }
}
