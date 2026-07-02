package ejercicio_001.archivos.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "contactos")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String nombre;
    private String email;
    private String telefono;


}

