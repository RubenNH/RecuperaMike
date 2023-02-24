package mx.edu.utez.ViajesReyPalomo.controller.viajes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.ViajesReyPalomo.models.destinos.Destino;
import mx.edu.utez.ViajesReyPalomo.models.usuarios.Usuario;
import mx.edu.utez.ViajesReyPalomo.models.viajes.Viaje;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ViajeDto {
    private Long idviaje;
    private Date fechasalida;
    private Date fechaingreso;
    private Usuario idusuario;
    private Destino iddestino;


    public Viaje parseToTrainer() {
        return new Viaje(
                getIdviaje(),getFechasalida(),getFechaingreso(),getIdusuario(),getIddestino()
        );
    }
}
