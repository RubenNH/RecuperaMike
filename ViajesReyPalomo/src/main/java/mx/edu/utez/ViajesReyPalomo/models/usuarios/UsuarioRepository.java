package mx.edu.utez.ViajesReyPalomo.models.usuarios;

import mx.edu.utez.ViajesReyPalomo.models.destinos.Destino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends
        JpaRepository<Usuario, Long> {
    boolean existsByNameUsuario(String nameUsuario);
}

