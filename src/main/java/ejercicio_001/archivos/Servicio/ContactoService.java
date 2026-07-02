package ejercicio_001.archivos.Servicio;

import ejercicio_001.archivos.modelo.Contacto;
import ejercicio_001.archivos.repositorio.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService {

    private final ContactoRepository contactoRepository;

    @Autowired
    public ContactoService(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    public List<Contacto> obtenerTodos() {
        return contactoRepository.findAll();
    }

    public Contacto obtenerPorId(Long id) {
        return contactoRepository.findById(id).orElse(null);
    }

    public void guardarContacto(Contacto contacto) {
        contactoRepository.save(contacto);
    }

    public void eliminarContacto(Long id) {
        contactoRepository.deleteById(id);
    }
}
