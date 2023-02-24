package mx.edu.utez.ViajesReyPalomo.models.usuarios;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.ViajesReyPalomo.models.viajes.Viaje;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;
    private String nameUsuario;
    private String email;
    private Date birtday;

    @OneToMany(mappedBy = "idusuario")
    private List<Viaje> viajes;
}
