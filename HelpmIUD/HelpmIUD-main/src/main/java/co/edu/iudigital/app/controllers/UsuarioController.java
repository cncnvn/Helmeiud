package co.edu.iudigital.app.controllers;

import co.edu.iudigital.app.dtos.CasoDTO;
import co.edu.iudigital.app.dtos.UsuarioDTO;
import co.edu.iudigital.app.models.Usuario;
import co.edu.iudigital.app.services.ifaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired

    private IUsuarioService usuarioService;


    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> index(){
        return ResponseEntity.ok()
                .body(usuarioService.getAll());
    }

    @PostMapping("/crear")
    public ResponseEntity<UsuarioDTO> save(
            @Validated @RequestBody UsuarioDTO usuario
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.save(usuario));
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UsuarioDTO> edit(
            @PathVariable Long id,
            @Validated @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO editUsuario = usuarioService.edit(id, usuarioDTO);
        if (editUsuario != null) {
            return ResponseEntity.ok(editUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/listar/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.getById(id);
        if (usuario != null){
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
