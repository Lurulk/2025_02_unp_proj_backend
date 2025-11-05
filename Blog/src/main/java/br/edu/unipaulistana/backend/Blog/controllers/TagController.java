package br.edu.unipaulistana.backend.Blog.controllers;

import br.edu.unipaulistana.backend.Blog.domainmodel.TagC;
import br.edu.unipaulistana.backend.Blog.service.TagService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tags")
//@RequiredArgsConstructor
@Tag(name = "Tags",description = "Operações relativas a tags")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    @Operation(method = "GET", summary = "listar todos as tags")
    public ResponseEntity<List<TagC>> findAll(){
        return ResponseEntity.ok(this.tagService.findAll());
    }

    //    GET http://localhost:8080/tags/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TagC> findTagCById(@PathVariable UUID id){
        return ResponseEntity.ok(this.tagService.findById(id));
    }

    //DELETE http://localshot:8080/tags/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTagCById(@PathVariable UUID id){
        this.tagService.deleteById(id);
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<TagC> createTagC(@RequestBody TagC tagC){
        return new ResponseEntity<>(this.tagService.create(tagC),  HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TagC> updateTagC(@RequestBody TagC tagC){
        return new ResponseEntity<>(this.tagService.update(tagC),  HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<TagC> patchTagC(@RequestBody TagC tagC){
        return new ResponseEntity<>(this.tagService.partialUpdate(tagC), HttpStatus.CREATED);
    }
}
