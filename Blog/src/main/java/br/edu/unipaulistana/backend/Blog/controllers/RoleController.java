package br.edu.unipaulistana.backend.Blog.controllers;

import br.edu.unipaulistana.backend.Blog.domainmodel.Role;
import br.edu.unipaulistana.backend.Blog.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/roles")
//@RequiredArgsConstructor
@Tag(name = "Papéis",description = "Operações relativas a papéis")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    @Operation(method = "GET", summary = "listar todos os papéis")
    public ResponseEntity<List<Role>> findAll(){
        return ResponseEntity.ok(this.roleService.findAll());
    }

    //    GET http://localhost:8080/roles/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Role> findRoleById(@PathVariable UUID id){
        return ResponseEntity.ok(this.roleService.findById(id));
    }

    //DELETE http://localshot:8080/roles/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoleById(@PathVariable UUID id){
        this.roleService.deleteById(id);
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return new ResponseEntity<>(this.roleService.create(role),  HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Role> updateRole(@RequestBody Role role){
        return new ResponseEntity<>(this.roleService.update(role),  HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Role> patchRole(@RequestBody Role role){
        return new ResponseEntity<>(this.roleService.partialUpdate(role), HttpStatus.CREATED);
    }
}
