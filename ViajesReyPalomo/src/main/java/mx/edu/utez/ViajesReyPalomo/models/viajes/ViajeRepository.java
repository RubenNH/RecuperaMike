package mx.edu.utez.ViajesReyPalomo.models.viajes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ViajeRepository  extends
        JpaRepository<Viaje, Long> {
}