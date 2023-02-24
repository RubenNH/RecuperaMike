package mx.edu.utez.ViajesReyPalomo.controller.usuarios;

import mx.edu.utez.ViajesReyPalomo.controller.usuarios.dto.UsuarioDto;
import mx.edu.utez.ViajesReyPalomo.servicies.usuarios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-reypalomo/user")
@CrossOrigin(origins = {"*"})
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public ResponseEntity getAll() {
        return new ResponseEntity(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(
            @PathVariable("id") Long id
    ) {
        System.out.println(id);
        return new ResponseEntity(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity save(
            @RequestBody UsuarioDto user
    ) {
        return new ResponseEntity(
                this.service.insert(user.parseToTrainer()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity update(
            @RequestBody UsuarioDto user
    ) {
        return new ResponseEntity(
                this.service.update(user.parseToTrainer()),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable("id") long id
    ) {
        return new ResponseEntity(
                this.service.delete(id),
                HttpStatus.OK
        );
    }

}
