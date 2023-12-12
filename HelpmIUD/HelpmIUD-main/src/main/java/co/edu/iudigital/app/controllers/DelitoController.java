package co.edu.iudigital.app.controllers;

import co.edu.iudigital.app.dtos.DelitoDTO;
import co.edu.iudigital.app.dtos.DelitoDTORequest;
import co.edu.iudigital.app.services.ifaces.IDelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delitos")
public class DelitoController {

    @Autowired

    private IDelitoService delitoService;

    @GetMapping("/listar")
    public ResponseEntity<List<DelitoDTO>> index(){
        return ResponseEntity.ok()
                .body(delitoService.getAll());
    }

    @PostMapping("/crear")
    public ResponseEntity<DelitoDTO> save(
       @Validated @RequestBody DelitoDTORequest request
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(delitoService.save(request));
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<DelitoDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(delitoService.getById(id));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<DelitoDTO> editById(
            @PathVariable Long id,
            @Validated @RequestBody DelitoDTORequest request
    ) {
        DelitoDTO delitoDTO = delitoService.edit(id, request);
        return ResponseEntity.ok(delitoDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        delitoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
