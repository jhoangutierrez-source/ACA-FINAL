# Sistema de Inventario

**Estudiante:** Johan Sebastian Gutierrez España
**Curso:** Programación Orientada a Objetos

## Descripción
Aplicación de consola en Java que simula el inventario de una pequeña tienda.
La información se guarda en memoria (no usa base de datos ni interfaz gráfica).

## Funcionalidades
1. **Registrar producto**: código, nombre, precio y cantidad (valida números, negativos y códigos repetidos).
2. **Mostrar productos**: lista todos los productos y el valor total del inventario.
3. **Buscar producto por código**: muestra el producto o un error si no existe.
4. **Salir**.

## Clases utilizadas
| Clase | Descripción |
| --- | --- |
| `Producto` | Objeto con atributos privados, constructor, getters/setters y `mostrarInformacion()`. |
| `Inventario` | Clase contenedora: guarda un `ArrayList<Producto>`, un arreglo de categorías y los métodos agregar, mostrar y buscar. |
| `ProductoNoEncontradoException` | Excepción personalizada cuando un código no existe. |
| `Main` | Menú por consola. |

## Conceptos de POO aplicados
- Clases y objetos, atributos y métodos
- Encapsulamiento (atributos `private`, getters y setters)
- Relación entre clases (`Inventario` contiene `Producto`)
- Arreglo (`String[] categorias`) y lista (`ArrayList`) con recorrido `for`
- Manejo de errores: `try-catch` (`NumberFormatException`) y excepción personalizada
- Segundo `try-catch` (validación al registrar productos)
- Biblioteca estándar: `java.util.Scanner`, `java.util.ArrayList`

## Cómo ejecutar
Requiere Java 11 o superior.

```bash
javac *.java
java Main
```
