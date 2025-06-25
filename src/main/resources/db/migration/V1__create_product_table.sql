CREATE TABLE producto (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(255) NOT NULL,
                          descripcion TEXT,
                          precio DOUBLE NOT NULL,
                          stock INT NOT NULL
);