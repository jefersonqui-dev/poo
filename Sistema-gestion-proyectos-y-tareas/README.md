# Sistema de Gestión de Proyectos y Tareas

## Descripción
Este sistema implementa un modelo simple para gestionar proyectos y las tareas asociadas a ellos. Cada proyecto tiene un nombre, descripción y un límite máximo de tareas. Las tareas tienen descripción y estado (Pendiente, En Progreso, Completa).

## Arquitectura del Sistema

### Clases Principales

#### 1. Tarea
- **Propósito**: Representa una tarea individual dentro de un proyecto
- **Atributos**: 
  - `descripcion`: Descripción de la tarea
  - `estado`: Estado actual (Pendiente, En Progreso, Completa)
- **Estados**: Constantes estáticas para los diferentes estados

#### 2. Proyecto
- **Propósito**: Representa un proyecto que contiene múltiples tareas
- **Atributos**:
  - `nombre`: Nombre del proyecto
  - `descripcion`: Descripción del proyecto
  - `tareas`: Lista de tareas asociadas
  - `maxTareas`: Límite máximo de tareas permitidas
- **Funcionalidades**:
  - Agregar tareas (con validación de límite)
  - Eliminar tareas
  - Marcar tareas como completadas/en progreso
  - Mostrar todas las tareas
  - Estadísticas de tareas

#### 3. GestorProyectos
- **Propósito**: Gestiona la colección de proyectos
- **Funcionalidades**:
  - Agregar/eliminar proyectos
  - Buscar proyectos por nombre
  - Mostrar todos los proyectos
  - Resumen general del sistema

## Relaciones entre Clases

### Composición (Proyecto ↔ Tarea)
- **Tipo**: Composición fuerte
- **Justificación**: 
  - Las tareas no pueden existir independientemente del proyecto
  - Cuando se elimina un proyecto, sus tareas se eliminan automáticamente
  - Las tareas pierden su contexto y propósito sin el proyecto
  - El ciclo de vida de las tareas está completamente controlado por el proyecto

### Agregación (GestorProyectos ↔ Proyecto)
- **Tipo**: Agregación débil
- **Justificación**:
  - Los proyectos pueden existir independientemente del gestor
  - Si se elimina el gestor, los proyectos no se ven afectados
  - El gestor solo proporciona funcionalidades de gestión y organización

## Funcionalidades Implementadas

✅ **Representar características de un proyecto**
- Nombre, descripción, límite de tareas
- Métodos para modificar atributos

✅ **Representar características de una tarea**
- Descripción y estado
- Estados predefinidos (Pendiente, En Progreso, Completa)

✅ **Modelar relación proyecto-tareas**
- Composición implementada con List<Tarea>
- Eliminación automática de tareas al eliminar proyecto

✅ **Límite máximo de tareas por proyecto**
- Constructor con parámetro maxTareas
- Validación al agregar tareas
- Constructor por defecto con límite de 10 tareas

✅ **Agregar tareas a un proyecto**
- Métodos para agregar tareas existentes o crear nuevas
- Validación de límite máximo

✅ **Mostrar todas las tareas de un proyecto**
- Método `mostrarTareas()` específico
- Información detallada con índices

✅ **Marcar tareas como completas**
- Método `marcarTareaCompleta(int indice)`
- Método `marcarTareaEnProgreso(int indice)`
- Validación de índices válidos

## Características Adicionales

- **Estadísticas**: Conteo de tareas por estado
- **Validaciones**: Límites de tareas, índices válidos
- **Interfaz de usuario**: Métodos para mostrar información de forma legible
- **Gestión de errores**: Mensajes informativos para operaciones fallidas
- **Inmutabilidad**: Retorno de copias de listas para evitar modificación externa

## Ejecución del Sistema

Para ejecutar el sistema:

```bash
cd Sistema-gestion-proyectos-y-tareas/src
javac *.java
java App
```

## Ejemplo de Uso

El sistema incluye una demostración completa que muestra:
1. Creación de proyectos con diferentes límites
2. Agregado de tareas (incluyendo validación de límites)
3. Cambio de estados de tareas
4. Visualización de información
5. Eliminación de proyectos (demostrando composición)
6. Estadísticas del sistema

## Ventajas del Diseño

1. **Separación de responsabilidades**: Cada clase tiene una responsabilidad específica
2. **Encapsulamiento**: Atributos privados con acceso controlado
3. **Composición apropiada**: Las tareas son parte integral del proyecto
4. **Flexibilidad**: Límites configurables por proyecto
5. **Robustez**: Validaciones y manejo de errores
6. **Mantenibilidad**: Código bien documentado y estructurado
