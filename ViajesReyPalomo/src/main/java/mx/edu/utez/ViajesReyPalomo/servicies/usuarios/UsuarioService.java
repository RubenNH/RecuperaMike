package mx.edu.utez.ViajesReyPalomo.servicies.usuarios;

import mx.edu.utez.ViajesReyPalomo.models.usuarios.Usuario;
import mx.edu.utez.ViajesReyPalomo.models.usuarios.UsuarioRepository;
import mx.edu.utez.ViajesReyPalomo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Response getAll() {
        return new Response<List<Usuario>>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    public Response getOne(Long id) {
        if (this.repository.existsById(id))
            return new Response<Usuario>(
                    this.repository.findById(id).get(),
                    false,
                    200,
                    "OK"
            );
        return new Response(
                null,
                true,
                200,
                "No existe este user"
        );
    }

    public Response insert(Usuario user) {
        if (this.repository.existsByNameUsuario(user.getNameUsuario()))
            return new Response(
                    null,
                    true,
                    200,
                    "user existente"
            );
        return new Response(
                this.repository.saveAndFlush(user),
                false,
                200,
                "user registrado correctamente"
        );
    }

    public Response update(Usuario user) {
        if (this.repository.existsById(user.getIdusuario()))
            return new Response(
                    this.repository.saveAndFlush(user),
                    false,
                    200,
                    "user actualizado correctamente"
            );
        return new Response(
                null,
                true,
                200,
                "No existe este user"
        );
    }

    public Response delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return new Response(
                    null,
                    false,
                    200,
                    "user eliminado correctamente"
            );
        }
        return new Response(
                null,
                true,
                200,
                "No existe este user"
        );
    }
}
