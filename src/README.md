# 🏪 Proyecto Magatzem (Gilded Rose Refactoring)

Este proyecto consiste en la refactorización arquitectónica de un sistema de gestión de inventario y almacén (*Magatzem*) basado en el famoso kata **Gilded Rose**. El código original presentaba una alta complejidad cognitiva debido a una estructura masiva de condiciones anidadas (`if-else`), dificultando su mantenimiento y escalabilidad.

## 🛠️ Patrones de Diseño Aplicados

Para resolver el problema del "código espagueti" y cumplir con las mejores prácticas de la ingeniería de software, se han implementado dos patrones de diseño creacionales y de comportamiento:

1. **Patrón Strategy (Estrategia):** Se ha aislado el comportamiento de actualización de cada tipo de artículo en su propia clase independiente. De esta manera, el almacén no necesita conocer las reglas de negocio específicas de cómo envejece un queso, una entrada o un objeto legendario.
2. **Patrón Simple Factory (Factoría):** Una clase encargada de centralizar la creación de las estrategias. Al recibir el nombre de un artículo, determina dinámicamente qué lógica de actualización se le debe aplicar.

---

## 📐 Principios SOLID Cumplidos

Gracias a la introducción de estos patrones, el diseño actual respeta estrictamente los principios de desarrollo limpio:

* **Principio de Responsabilidad Única (SRP):** La clase `Magatzem` ahora solo tiene una única responsabilidad: iterar sobre los productos y delegar la ejecución. Cada estrategia maneja en exclusividad su propia regla de negocio.
* **Principio Abierto/Cerrado (OCP):** El sistema queda totalmente abierto a la extensión pero cerrado a la modificación. Si en el futuro se añade un nuevo artículo, no es necesario modificar la lógica existente de `Magatzem.java`; basta con crear una nueva clase e incluirla en la factoría.

---

## 📦 Estructura del Código Fuente

El diseño modular del proyecto se organiza de la siguiente manera dentro del directorio de fuentes (`src/main/java`):

* **`Article.java`**: Entidad básica que representa un artículo en el inventario con sus atributos de estado (`nom`, `diesPerVendre`, `qualitat`).
* **`Magatzem.java`**: Clase controladora principal que procesa el inventario. Reduce su bucle original a una delegación limpia hacia la factoría.
* **`ActualitzadorEstrategia.java`**: Interfaz común que define el contrato de comportamiento para todas las variantes de actualización.
* **`EstrategiaFactory.java`**: Proveedor encargado de instanciar y mapear la estrategia adecuada según el nombre del producto inspeccionado.
* **`EstrategiaNormal.java`**, **`EstrategiaFormatge.java`**, **`EstrategiaEntrades.java`**, **`EstrategiaLlegendari.java`**: Clases individuales con algoritmos específicos de degradación y valorización comercial.

---

## 🧪 Cobertura de Pruebas Unitarias

Se ha implementado una batería exhaustiva de pruebas automatizadas utilizando **JUnit 5** dentro de `MagatzemTest.java`. Estas pruebas validan de forma rigurosa cada una de las ramificaciones lógicas originales, asegurando que la refactorización mantiene el comportamiento esperado bajo cualquier condición extrema.