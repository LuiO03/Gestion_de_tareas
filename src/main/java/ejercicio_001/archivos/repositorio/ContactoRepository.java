package ejercicio_001.archivos.repositorio;

import ejercicio_001.archivos.modelo.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
    // Puedes agregar métodos adicionales si es necesario
}
