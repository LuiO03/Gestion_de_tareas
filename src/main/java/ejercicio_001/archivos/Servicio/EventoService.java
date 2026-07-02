package ejercicio_001.archivos.Servicio;

import ejercicio_001.archivos.modelo.Evento;
import ejercicio_001.archivos.repositorio.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    @Autowired
    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> obtenerTodos() {
        return eventoRepository.findAll();
    }

    public Evento obtenerPorId(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    public void guardarEvento(Evento evento) {
        if (evento.getId() != null) {
            // Si el evento tiene un ID, busca el evento existente en la base de datos
            Evento eventoExistente = eventoRepository.findById(evento.getId()).orElse(null);
            if (eventoExistente != null) {
                // Actualiza los valores del evento existente con los nuevos valores del evento recibido
                eventoExistente.setTitulo(evento.getTitulo());
                eventoExistente.setFecha(evento.getFecha());
                eventoExistente.setHora(evento.getHora());
                eventoExistente.setDescripcion(evento.getDescripcion());
                // Puedes actualizar más campos aquí si es necesario

                // Guarda el evento actualizado en la base de datos
                eventoRepository.save(eventoExistente);
                return;
            }
        }
        // Si no se encuentra un evento existente o el ID es nulo, se guarda un nuevo evento
        eventoRepository.save(evento);
    }

    public void eliminarEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}