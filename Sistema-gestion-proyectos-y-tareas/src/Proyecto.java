import java.util.ArrayList;
import java.util.List;

/**
 * Clase Proyecto que representa un proyecto con sus características y tareas
 * asociadas.
 * 
 * RELACIÓN DE COMPOSICIÓN:
 * - Un proyecto está COMPUESTO por tareas (composición fuerte)
 * - Las tareas no pueden existir independientemente del proyecto
 * - Cuando se elimina un proyecto, todas sus tareas se eliminan automáticamente
 * - El ciclo de vida de las tareas está completamente controlado por el
 * proyecto
 * 
 * Justificación de Composición vs Agregación:
 * - COMPOSICIÓN: Las tareas son parte integral del proyecto y no tienen sentido
 * sin él. Si el proyecto se elimina, las tareas pierden su contexto y
 * propósito.
 * - AGREGACIÓN sería si las tareas pudieran existir independientemente y ser
 * reutilizadas en otros proyectos, lo cual no es el caso aquí.
 */
public class Proyecto {
    private String nombre;
    private String descripcion;
    private List<Tarea> tareas;
    private int maxTareas; // Límite máximo de tareas permitidas

    // Constructor con límite de tareas
    public Proyecto(String nombre, String descripcion, int maxTareas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.maxTareas = maxTareas;
        this.tareas = new ArrayList<>();
    }

    // Constructor por defecto con límite de 10 tareas
    public Proyecto(String nombre, String descripcion) {
        this(nombre, descripcion, 10);
    }

    // Métodos para gestionar tareas
    public boolean agregarTarea(Tarea tarea) {
        if (tareas.size() >= maxTareas) {
            System.out.println("Error: No se puede agregar más tareas. Límite máximo alcanzado (" + maxTareas + ").");
            return false;
        }
        tareas.add(tarea);
        return true;
    }

    public boolean agregarTarea(String descripcion) {
        if (tareas.size() >= maxTareas) {
            System.out.println("Error: No se puede agregar más tareas. Límite máximo alcanzado (" + maxTareas + ").");
            return false;
        }
        tareas.add(new Tarea(descripcion));
        return true;
    }

    public void eliminarTarea(Tarea tarea) {
        tareas.remove(tarea);
    }

    public List<Tarea> getTareas() {
        return new ArrayList<>(tareas); // Retorna una copia para evitar modificación externa
    }

    public int getCantidadTareas() {
        return tareas.size();
    }

    public int getTareasCompletadas() {
        return (int) tareas.stream()
                .filter(t -> Tarea.COMPLETA.equals(t.getEstado()))
                .count();
    }

    public int getTareasPendientes() {
        return (int) tareas.stream()
                .filter(t -> Tarea.PENDIENTE.equals(t.getEstado()))
                .count();
    }

    // Método para marcar una tarea como completa
    public boolean marcarTareaCompleta(int indiceTarea) {
        if (indiceTarea >= 0 && indiceTarea < tareas.size()) {
            tareas.get(indiceTarea).setEstado(Tarea.COMPLETA);
            return true;
        }
        System.out.println("Error: Índice de tarea inválido.");
        return false;
    }

    // Método para marcar una tarea como en progreso
    public boolean marcarTareaEnProgreso(int indiceTarea) {
        if (indiceTarea >= 0 && indiceTarea < tareas.size()) {
            tareas.get(indiceTarea).setEstado(Tarea.EN_PROGRESO);
            return true;
        }
        System.out.println("Error: Índice de tarea inválido.");
        return false;
    }

    // Método para mostrar todas las tareas de un proyecto
    public void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas en este proyecto.");
            return;
        }

        System.out.println("=== TAREAS DEL PROYECTO: " + nombre + " ===");
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i + 1) + ". " + tareas.get(i));
        }
        System.out.println("Límite de tareas: " + tareas.size() + "/" + maxTareas);
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMaxTareas() {
        return maxTareas;
    }

    public void setMaxTareas(int maxTareas) {
        this.maxTareas = maxTareas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Proyecto: ").append(nombre).append("\n");
        sb.append("Descripción: ").append(descripcion).append("\n");
        sb.append("Límite de tareas: ").append(getCantidadTareas()).append("/").append(maxTareas).append("\n");
        sb.append("Tareas completadas: ").append(getTareasCompletadas()).append("\n");
        sb.append("Tareas pendientes: ").append(getTareasPendientes()).append("\n");
        sb.append("Tareas:\n");

        for (Tarea tarea : tareas) {
            sb.append("  - ").append(tarea.toString()).append("\n");
        }

        return sb.toString();
    }
}
