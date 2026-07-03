# Agenda Virtual

Aplicación web para gestionar **tareas** y **contactos** con una interfaz basada en Spring Boot y Thymeleaf.

> En el código interno el módulo aparece como `eventos`, pero en la aplicación y en esta documentación debe entenderse como **tareas**.

## Tecnologías usadas

- **Java 21**
- **Spring Boot 3.2.0**
- **Spring Web**
- **Spring Data JPA / Hibernate**
- **Spring Validation**
- **Thymeleaf**
- **Thymeleaf Layout Dialect**
- **MySQL**
- **Lombok**
- **Spring Boot DevTools**
- **jQuery / jQuery UI** para el selector de fecha
- **CSS personalizado**
- **Remix Icon**
- **Google Fonts**

## Funcionalidades

- Inicio de sesión básico
- Dashboard principal
- Gestión de **tareas**
  - listar
  - crear
  - editar
  - eliminar
- Gestión de **contactos**
  - listar
  - crear
  - editar
  - eliminar

## Estructura general

- `controller/`: controladores web
- `Servicio/`: lógica de negocio
- `repositorio/`: acceso a datos con JPA
- `modelo/`: entidades persistidas
- `templates/`: vistas Thymeleaf
- `static/`: estilos y recursos frontend

## Flujo de la aplicación

1. El usuario accede a `/login`.
2. Si las credenciales son correctas, entra al `/dashboard`.
3. Desde el dashboard puede ir al módulo de **tareas** o **contactos**.
4. Cada módulo permite crear, editar, listar y eliminar registros.

## Requisitos

- Java 21
- Maven
- MySQL

## Configuración

La conexión a base de datos se define en `src/main/resources/application.properties`:

- Base de datos: `Agenda`
- Usuario: `root`
- Puerto de la app: `8080`

## Ejecución

```bash
mvn spring-boot:run
```

Luego abre:

```text
http://localhost:8080/login
```

## Notas

- La vista de tareas usa el prefijo `/eventos`, pero visualmente el sistema muestra el módulo como **Tareas**.
- El diseño está pensado para una agenda personal con navegación simple entre módulos.
