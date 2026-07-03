package ejercicio_001.archivos.modelo;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.sql.Time;
import java.util.Date;

@Entity
@Data
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String titulo;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fecha;

    @DateTimeFormat(pattern = "HH:mm")
    private Time hora;

    @Column(name = "descripcion")
    private String descripcion;

    // Getters y setters
}

