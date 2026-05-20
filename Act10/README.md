Casos de Pruebas:
1-
Escenario: Crear un producto con datos válidos
Dado que  el usuario tiene acceso al sistema de productos
Cuando envía un producto con nombre "Teclado" y precio 25000
Entonces el sistema guarda el producto correctamente
Y devuelve una confirmación de creación

2-
Escenario: Intentar crear un producto sin nombre
Dado el usuario tiene acceso al sistema de productos
Cuando envía un producto con nombre vacío y precio 25000
Entonces el sistema devuelve un error de validación

3-
Escenario: Intentar crear un producto sin precio
Dado que  el usuario tiene acceso al sistema de productos
Cuando envía un producto con nombre "Mouse" y precio nulo
Entonces el sistema devuelve un error de validación

4-
Escenario: Intentar crear un producto con precio negativo
Dado que el usuario tiene acceso al sistema de productos
Cuando envía un producto con nombre "Monitor" y precio -5000
Entonces el sistema rechaza la solicitud
Y muestra un mensaje de error de validación

5-
Escenario: Consultar todos los productos registrados
Dado que  existen productos en el sistema
Cuando el usuario solicita la lista de productos
Entonces el sistema devuelve todos los productos almacenados

6-
Escenario: Intentar crear un producto con precio igual a cero
Dado que el usuario tiene acceso al sistema de productos
Cuando envía un producto con nombre "Mouse" y precio 0
Entonces el sistema rechaza la solicitud