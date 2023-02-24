package mx.edu.utez.ViajesReyPalomo.servicies.viajes;

import mx.edu.utez.ViajesReyPalomo.models.viajes.Viaje;
import mx.edu.utez.ViajesReyPalomo.models.viajes.ViajeRepository;
import mx.edu.utez.ViajesReyPalomo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ViajeService {
    @Autowired
    private ViajeRepository repository;

    public Response getAll() {
        return new Response<List<Viaje>>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    public Response getOne(Long id) {
        if (this.repository.existsById(id))
            return new Response<Viaje>(
                    this.repository.findById(id).get(),
                    false,
                    200,
                    "OK"
            );
        return new Response(
                null,
                true,
                200,
                "No existe este viaje"
        );
    }

    public Response insert(Viaje vj) {
        if (this.repository.existsById(vj.getIdviaje()))
            return new Response(
                    null,
                    true,
                    200,
                    "viaje existente"
            );
        return new Response(
                this.repository.saveAndFlush(vj),
                false,
                200,
                "viaje registrado correctamente"
        );
    }

    public Response update(Viaje vj) {
        if (this.repository.existsById(vj.getIdviaje()))
            return new Response(
                    this.repository.saveAndFlush(vj),
                    false,
                    200,
                    "viaje actualizado correctamente"
            );
        return new Response(
                null,
                true,
                200,
                "No existe este viaje"
        );
    }

    public Response delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return new Response(
                    null,
                    false,
                    200,
                    "viaje eliminado correctamente"
            );
        }
        return new Response(
                null,
                true,
                200,
                "No existe este viaje"
        );
    }
}
