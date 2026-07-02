create database Agenda;
use Agenda;


CREATE TABLE Usuarios (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE Eventos (
    event_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    titulo VARCHAR(255) NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    descripcion TEXT,
    FOREIGN KEY (user_id) REFERENCES Usuarios(user_id)
);


CREATE TABLE Contactos (
    contact_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    telefono VARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES Usuarios(user_id)
);

INSERT INTO Usuarios (username, password) VALUES ('user', '123');

-- Asegúrate de tener un 'user_id' válido (en este caso, asumimos que es 1)
INSERT INTO Contactos (user_id, nombre, email, telefono) VALUES (1, 'Nombre Contacto', 'correo@ejemplo.com', '123456789');




