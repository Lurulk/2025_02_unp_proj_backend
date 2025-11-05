package br.edu.unipaulistana.backend.Blog.controllers;

import br.edu.unipaulistana.backend.Blog.domainmodel.Post;
import br.edu.unipaulistana.backend.Blog.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
//@RequiredArgsConstructor
@Tag(name = "Publicações",description = "Operações relativas a publicações")
public class PostController {
    private final PostService postService;

    public PostController(PostService PostService) {
        this.postService = PostService;
    }

    @GetMapping
    @Operation(method = "GET", summary = "listar todos as publicações")
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok(this.postService.findAll());
    }

    //    GET http://localhost:8080/posts/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable UUID id){
        return ResponseEntity.ok(this.postService.findById(id));
    }

    //DELETE http://localshot:8080/posts/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable UUID id){
        this.postService.deleteById(id);
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        return new ResponseEntity<>(this.postService.create(post),  HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Post> updatePost(@RequestBody Post post){
        return new ResponseEntity<>(this.postService.update(post),  HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Post> patchPost(@RequestBody Post post){
        return new ResponseEntity<>(this.postService.partialUpdate(post), HttpStatus.CREATED);
    }
}
