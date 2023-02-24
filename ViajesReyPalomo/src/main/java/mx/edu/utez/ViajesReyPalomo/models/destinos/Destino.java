package mx.edu.utez.ViajesReyPalomo.models.destinos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.ViajesReyPalomo.models.viajes.Viaje;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "destino")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iddestino;
    private String namedestino;
    private String description;
    private Integer price;
    private Float calification;
    private Boolean disponible;

    @OneToMany(mappedBy = "iddestino")
    private List<Viaje> viajes;
}
