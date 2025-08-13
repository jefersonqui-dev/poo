/**
 * Clase Tarea que representa una tarea individual dentro de un proyecto.
 * 
 * RELACIÓN DE COMPOSICIÓN:
 * - Esta clase es parte de la composición con Proyecto
 * - Las tareas no pueden existir independientemente de un proyecto
 * - Su ciclo de vida está completamente controlado por el proyecto padre
 */
public class Tarea {
    private String descripcion;
    private String estado;

    // Estados posibles de una tarea
    public static final String PENDIENTE = "Pendiente";
    public static final String EN_PROGRESO = "En Progreso";
    public static final String COMPLETA = "Completa";

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.estado = PENDIENTE; // Por defecto, las tareas están pendientes
    }

    // Getters y setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tarea: " + descripcion + " - Estado: " + estado;
    }
}
