package br.edu.unipaulistana.backend.Blog.controllers;

import br.edu.unipaulistana.backend.Blog.domainmodel.Profile;
import br.edu.unipaulistana.backend.Blog.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/profiles")
//@RequiredArgsConstructor
@Tag(name = "Perfils",description = "Operações relativas a perfils")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    @Operation(method = "GET", summary = "listar todos os perfils")
    public ResponseEntity<List<Profile>> findAll(){
        return ResponseEntity.ok(this.profileService.findAll());
    }

    //    GET http://localhost:8080/profiles/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Profile> findProfileById(@PathVariable UUID id){
        return ResponseEntity.ok(this.profileService.findById(id));
    }

    //DELETE http://localshot:8080/profiles/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfileById(@PathVariable UUID id){
        this.profileService.deleteById(id);
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile){
        return new ResponseEntity<>(this.profileService.create(profile),  HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile){
        return new ResponseEntity<>(this.profileService.update(profile),  HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Profile> patchProfile(@RequestBody Profile profile){
        return new ResponseEntity<>(this.profileService.partialUpdate(profile), HttpStatus.CREATED);
    }
}
