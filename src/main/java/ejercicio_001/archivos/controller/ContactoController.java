package ejercicio_001.archivos.controller;

import ejercicio_001.archivos.Servicio.ContactoService;
import ejercicio_001.archivos.modelo.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contactos")
public class ContactoController {

    private final ContactoService contactoService;

    @Autowired
    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @GetMapping
    public String listarContactos(Model model) {
        List<Contacto> contactos = contactoService.obtenerTodos();
        model.addAttribute("contactos", contactos);
        return "contactos/listaContactos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoContacto(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "contactos/formularioContacto";
    }

    @PostMapping("/guardar")
    public String guardarContacto(@ModelAttribute("contacto") Contacto contacto) {
        contactoService.guardarContacto(contacto);
        return "redirect:/contactos";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioEditarContacto(@PathVariable Long id, Model model) {
        Contacto contacto = contactoService.obtenerPorId(id);
        model.addAttribute("contacto", contacto);
        return "contactos/formularioContacto";
    }


    @GetMapping("/{id}/eliminar")
    public String eliminarContacto(@PathVariable Long id) {
        contactoService.eliminarContacto(id);
        return "redirect:/contactos";
    }
}
