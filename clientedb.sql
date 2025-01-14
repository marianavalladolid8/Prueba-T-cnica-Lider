	CREATE DATABASE clientedb; -- Se crea base de datos cliente
    USE clienteDB;
    -- Se crean las entidades y sus atributos
    SHOW TABLES; -- para ver si se crearon las tablas
    CREATE DATABASE clientesDB;
USE clientesDB;
-- Script generados en consola para crear entidad cliente
CREATE TABLE clientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    correo VARCHAR(100) UNIQUE
);
-- insercion de datos a entidad cliente
INSERT INTO clientes (nombre, correo) VALUES ('Juan Pérez', 'juan.perez@email.com');
INSERT INTO clientes (nombre, correo) VALUES ('Ana Gómez', 'ana.gomez@email.com');

    SELECT * FROM cliente; -- ver la tabla cliente y su contenido
    
    DESCRIBE cliente; -- descripcion de la tabla cliente y su composición
    
    ALTER TABLE cliente MODIFY COLUMN id BIGINT AUTO_INCREMENT; -- modificación de la tabla cliente para hacer el id autoincremental

DROP TABLE IF EXISTS cliente;

