package ejercicio_001.archivos.controller;

import ejercicio_001.archivos.modelo.Usuario;
import ejercicio_001.archivos.repositorio.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UsuarioRepository usuarioRepository;

    public LoginController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String mostrarDashboard() {
        return "home";
    }


    @PostMapping("/login")
    public String loginPost(String username, String password, Model model) {
        Usuario usuario = usuarioRepository.findByUsername(username);

        if (usuario != null && usuario.getPassword().equals(password)) {
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "index";
        }
    }
}
