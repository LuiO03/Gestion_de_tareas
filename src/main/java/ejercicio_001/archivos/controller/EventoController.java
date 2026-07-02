package ejercicio_001.archivos.controller;

import ejercicio_001.archivos.Servicio.EventoService;

import ejercicio_001.archivos.modelo.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    @Autowired
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public String listarEventos(Model model) {
        List<Evento> eventos = eventoService.obtenerTodos();
        model.addAttribute("eventos", eventos);
        return "eventos/listaEventos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoEvento(Model model) {
        model.addAttribute("evento", new Evento());
        return "eventos/formularioEvento";
    }

    @PostMapping("/guardar")

    public String guardarEvento(@Validated @ModelAttribute("evento") Evento evento, BindingResult result) {
        if (result.hasErrors()) {
            return "eventos/formularioEvento";
        }

        if (evento.getId() != null) {
            Evento eventoExistente = eventoService.obtenerPorId(evento.getId());
            if (eventoExistente != null) {
                // Actualiza los valores del evento existente con los nuevos valores del evento recibido
                eventoExistente.setTitulo(evento.getTitulo());
                eventoExistente.setFecha(evento.getFecha());
                eventoExistente.setHora(evento.getHora());
                eventoExistente.setDescripcion(evento.getDescripcion());

                // El evento existente ya está actualizado, no es necesario guardar de nuevo.
                // El servicio debe reflejar estos cambios automáticamente.
                return "redirect:/eventos";
            }
        }

        // Si el ID es nulo o no se encuentra el evento existente, guarda un nuevo evento.
        eventoService.guardarEvento(evento);
        return "redirect:/eventos";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioEditarEvento(@PathVariable Long id, Model model) {
        Evento evento = eventoService.obtenerPorId(id);
        model.addAttribute("evento", evento);
        return "eventos/formularioEvento";
    }

    @GetMapping("/{id}/eliminar")
    public String eliminarEvento(@PathVariable Long id) {
        eventoService.eliminarEvento(id);
        return "redirect:/eventos";
    }
}
