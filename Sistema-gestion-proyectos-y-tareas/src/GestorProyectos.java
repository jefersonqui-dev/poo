import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase GestorProyectos que maneja la colección de proyectos.
 * 
 * RELACIÓN DE AGREGACIÓN:
 * - El gestor contiene proyectos (agregación débil)
 * - Los proyectos pueden existir independientemente del gestor
 * - Si se elimina el gestor, los proyectos no se ven afectados
 * - El gestor solo proporciona funcionalidades de gestión y organización
 */
public class GestorProyectos {
    private List<Proyecto> proyectos;

    public GestorProyectos() {
        this.proyectos = new ArrayList<>();
    }

    // Métodos para gestionar proyectos
    public void agregarProyecto(Proyecto proyecto) {
        proyectos.add(proyecto);
    }

    public void agregarProyecto(String nombre, String descripcion) {
        proyectos.add(new Proyecto(nombre, descripcion));
    }

    public void agregarProyecto(String nombre, String descripcion, int maxTareas) {
        proyectos.add(new Proyecto(nombre, descripcion, maxTareas));
    }

    public boolean eliminarProyecto(String nombre) {
        return proyectos.removeIf(p -> p.getNombre().equals(nombre));
    }

    public Optional<Proyecto> buscarProyecto(String nombre) {
        return proyectos.stream()
                .filter(p -> p.getNombre().equals(nombre))
                .findFirst();
    }

    public List<Proyecto> getProyectos() {
        return new ArrayList<>(proyectos);
    }

    public int getCantidadProyectos() {
        return proyectos.size();
    }

    public void mostrarTodosLosProyectos() {
        if (proyectos.isEmpty()) {
            System.out.println("No hay proyectos registrados.");
            return;
        }

        System.out.println("=== LISTADO DE PROYECTOS ===");
        for (int i = 0; i < proyectos.size(); i++) {
            System.out.println("\n--- Proyecto " + (i + 1) + " ---");
            System.out.println(proyectos.get(i));
        }
    }

    public void mostrarResumen() {
        System.out.println("=== RESUMEN GENERAL ===");
        System.out.println("Total de proyectos: " + getCantidadProyectos());

        int totalTareas = proyectos.stream()
                .mapToInt(Proyecto::getCantidadTareas)
                .sum();

        int totalTareasCompletadas = proyectos.stream()
                .mapToInt(Proyecto::getTareasCompletadas)
                .sum();

        System.out.println("Total de tareas: " + totalTareas);
        System.out.println("Total de tareas completadas: " + totalTareasCompletadas);
        System.out.println("Total de tareas pendientes: " + (totalTareas - totalTareasCompletadas));
    }
}
