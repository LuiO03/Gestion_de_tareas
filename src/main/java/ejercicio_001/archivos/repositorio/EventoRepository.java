package ejercicio_001.archivos.repositorio;

import ejercicio_001.archivos.modelo.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    // Puedes agregar métodos adicionales si es necesario
}

