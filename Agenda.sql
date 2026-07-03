drop database if exists Agenda;
CREATE DATABASE Agenda;
USE Agenda;

-- ==========================
-- TABLA USUARIOS
-- ==========================
CREATE TABLE Usuarios (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- ==========================
-- TABLA EVENTOS (TAREAS)
-- ==========================
CREATE TABLE Eventos (
    event_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    titulo VARCHAR(255) NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    descripcion TEXT,
    FOREIGN KEY (user_id) REFERENCES Usuarios(user_id)
);

-- ==========================
-- TABLA CONTACTOS
-- ==========================
CREATE TABLE Contactos (
    contact_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    telefono VARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES Usuarios(user_id)
);

-- ==========================
-- USUARIOS
-- ==========================
INSERT INTO Usuarios (username, password) VALUES
('user', '123'),
('luis', '123456'),
('maria', 'maria123'),
('carlos', 'carlos123'),
('ana', 'ana123');

-- ==========================
-- CONTACTOS
-- ==========================
INSERT INTO Contactos (user_id, nombre, email, telefono) VALUES
(1, 'Juan Pérez', 'juan@gmail.com', '987654321'),
(1, 'María López', 'maria@gmail.com', '912345678'),
(2, 'Pedro Gómez', 'pedro@gmail.com', '956789123'),
(2, 'Ana Torres', 'ana@gmail.com', '998877665'),
(3, 'Luis Rojas', 'luis@gmail.com', '945612378'),
(3, 'Sofía Díaz', 'sofia@gmail.com', '934567891'),
(4, 'Carlos Mendoza', 'carlos@gmail.com', '955443322'),
(5, 'Valeria Ruiz', 'valeria@gmail.com', '966778899');

-- ==========================
-- EVENTOS (TAREAS)
-- ==========================
INSERT INTO Eventos (user_id, titulo, fecha, hora, descripcion) VALUES
(1, 'Terminar informe', '2026-07-05', '09:00:00', 'Completar el informe mensual y enviarlo al jefe.'),
(1, 'Comprar víveres', '2026-07-05', '18:30:00', 'Comprar frutas, verduras y productos de limpieza.'),
(1, 'Estudiar Spring Boot', '2026-07-06', '20:00:00', 'Avanzar con controladores y JPA.'),

(2, 'Preparar presentación', '2026-07-07', '10:00:00', 'Crear las diapositivas para la reunión.'),
(2, 'Pagar servicios', '2026-07-08', '08:00:00', 'Cancelar luz, agua e internet.'),
(2, 'Ir al gimnasio', '2026-07-08', '19:00:00', 'Entrenamiento de fuerza.'),

(3, 'Actualizar CV', '2026-07-09', '16:00:00', 'Agregar nuevos proyectos y tecnologías.'),
(3, 'Revisar correos', '2026-07-09', '09:30:00', 'Responder mensajes pendientes.'),

(4, 'Hacer respaldo del sistema', '2026-07-10', '14:00:00', 'Realizar copia de seguridad de la base de datos.'),
(4, 'Reunión con cliente', '2026-07-10', '11:00:00', 'Revisar avances del proyecto.'),

(5, 'Leer documentación', '2026-07-11', '15:30:00', 'Leer documentación de Spring Security.'),
(5, 'Organizar escritorio', '2026-07-11', '17:00:00', 'Eliminar archivos innecesarios y ordenar carpetas.');