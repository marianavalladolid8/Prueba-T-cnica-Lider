API de Gestión de Clientes con Spring Boot

Este proyecto es una API RESTful desarrollada con Java y el framework Spring Boot para gestionar información de clientes. La API permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre los datos de clientes almacenados en una base de datos MySQL.

Descripción
La API tiene como objetivo la gestión de clientes en una aplicación utilizando Spring Boot y Spring Data JPA para interactuar con una base de datos. Proporciona métodos para agregar, buscar, actualizar y eliminar clientes, asegurando que las excepciones sean manejadas correctamente en cada operación.

Características
Creación de API: Desarrollada utilizando Java y Spring Boot. La API interactúa con una base de datos MySQL y permite realizar operaciones CRUD en los datos de los clientes.

Almacenamiento en Base de Datos: La base de datos utilizada es MySQL. Se configura para almacenar la información de los clientes y las operaciones se realizan mediante Spring Data JPA.

Definición de la entidad Cliente: La entidad Cliente se define con atributos como id, nombre y correo, junto con las configuraciones necesarias para persistirla en la base de datos mediante JPA.

Repositorio de Cliente: Utilizando Spring Data JPA, se crea un repositorio que proporciona métodos listos para realizar operaciones CRUD sobre la entidad Cliente, como guardar, actualizar, eliminar y buscar clientes por ID.

Servicio de Cliente: El servicio encapsula la lógica de negocio de las operaciones CRUD. Cada método en el servicio maneja las excepciones que puedan ocurrir durante las operaciones sobre los clientes.

Controlador REST para Cliente: Un controlador REST expone los endpoints para realizar las operaciones CRUD en los clientes. Se utilizan las anotaciones adecuadas de Spring Web para definir los métodos HTTP (GET, POST, PUT, DELETE).

Documentación de la API: Se proporciona documentación de los endpoints de la API, incluyendo detalles sobre los métodos, parámetros y ejemplos de respuesta.

Scripts SQL: El proyecto incluye configuraciones necesarias para que las tablas de la base de datos se creen automáticamente al ejecutar la aplicación por primera vez. Esto es gestionado por Spring Boot.

Scripts de Base de Datos: El archivo README incluye los scripts SQL para crear las tablas y agregar datos iniciales necesarios para probar las APIs en su primer uso.

Pruebas Unitarias: Se incluyen pruebas unitarias para verificar el correcto funcionamiento de los métodos de la API. Las pruebas aseguran que las operaciones de la API respondan correctamente y manejen las excepciones adecuadamente.

Repositorio Público: Al finalizar el desarrollo, el proyecto se sube a un repositorio público en GitHub o GitLab. El enlace al repositorio se comparte para su evaluación.


Endpoints de la API
. Obtener todos los clientes
Método: GET /clientes
Descripción: Devuelve una lista con todos los clientes registrados.

[
  {
    "id": 1,
    "nombre": "Juan Pérez",
    "correo": "juan.perez@email.com"
  },
  {
    "id": 2,
    "nombre": "Ana Gómez",
    "correo": "ana.gomez@email.com"
  }
]
2. Obtener un cliente por ID
Método: GET /clientes/{id}
Descripción: Devuelve la información de un cliente específico por su ID.

Parámetros:

id: El identificador único del cliente.
{
  "id": 1,
  "nombre": "Juan Pérez",
  "correo": "juan.perez@email.com"
}
3. Crear un nuevo cliente
Método: POST /clientes
Descripción: Crea un nuevo cliente en la base de datos.

Cuerpo de la solicitud:
{
  "nombre": "Paola Mireles",
  "correo": "paola.mireles@email.com"
}
4. Actualizar un cliente
Método: PUT /clientes/{id}
Descripción: Actualiza la información de un cliente existente.

Parámetros:

id: El identificador del cliente a actualizar.
5. Eliminar un cliente
Método: DELETE /clientes/{id}
Descripción: Elimina un cliente de la base de datos.

Parámetros:

id: El identificador único del cliente a eliminar.
La aplicación estará corriendo en http://localhost:8081. Se cambia por aparición de errores en 8080, decia que ya estaba ocupado mel puerto.

Base de Datos
El proyecto utiliza MySQL para almacenar los datos de los clientes. Asegúrate de tener MySQL instalado y configurado correctamente. Los scripts necesarios para la creación de las tablas y los datos iniciales están incluidos en el proyecto.

Script para crear la base de datos, la carpeta se agrega al repositorio.

Pruebas
Para asegurar el correcto funcionamiento de la API, hemos incluido pruebas unitarias que cubren los métodos CRUD. Las pruebas están implementadas utilizando JUnit y Mockito.

Se anexa carpera de imágenes 

Att: Mar Valladolid

Pd: Le puse todo mi corazoncito inexperto y ansioso, me disculpo de antemanto si no es lo que se espera, promero mejorar, estudiar,practicar mucho y trabajar en mi disléxica.
Gracias y que tenga Buen día.


Licencia
Este proyecto está licenciado bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.


