package mx.edu.utez.ViajesReyPalomo.controller.usuarios.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.ViajesReyPalomo.models.usuarios.Usuario;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuarioDto {
    private Long idusuario;
    private String nameusuario;
    private String email;
    private Date birtday;

    public Usuario parseToTrainer() {
        return new Usuario(
                getIdusuario(),
                getNameusuario(),
                getEmail(),
                getBirtday(),
                null
        );
    }
}
