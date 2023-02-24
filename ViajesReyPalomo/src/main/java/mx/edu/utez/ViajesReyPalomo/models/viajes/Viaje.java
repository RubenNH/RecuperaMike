package mx.edu.utez.ViajesReyPalomo.models.viajes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.ViajesReyPalomo.models.destinos.Destino;
import mx.edu.utez.ViajesReyPalomo.models.usuarios.Usuario;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "viaje")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idviaje;
    private Date fechasalida;
    private Date fechaingreso;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    @JsonIgnore
    private Usuario idusuario;

    @ManyToOne
    @JoinColumn(name = "iddestino")
    @JsonIgnore
    private Destino iddestino;
}
