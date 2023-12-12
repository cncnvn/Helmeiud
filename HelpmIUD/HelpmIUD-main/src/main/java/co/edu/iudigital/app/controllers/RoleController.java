package co.edu.iudigital.app.controllers;

import co.edu.iudigital.app.dtos.RoleDTO;
import co.edu.iudigital.app.models.Role;
import co.edu.iudigital.app.services.ifaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @GetMapping("/listar")
    public ResponseEntity<List<Role>> index(){
        return ResponseEntity.ok()
                .body(roleService.getAll());
    }

    @PostMapping("/crear")
    public ResponseEntity<RoleDTO> save(
            @Validated RoleDTO role
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(roleService.save(role));
    }
}
