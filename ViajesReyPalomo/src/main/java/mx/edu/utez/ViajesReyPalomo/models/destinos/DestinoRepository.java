package mx.edu.utez.ViajesReyPalomo.models.destinos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DestinoRepository extends
        JpaRepository<Destino, Long> {
}
