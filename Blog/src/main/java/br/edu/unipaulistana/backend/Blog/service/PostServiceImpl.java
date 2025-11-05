package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Post;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Post> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Post findById(UUID id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        this.repository.deleteById(id);
    }

    @Override
    public Post create(Post post) {
        if(post.getId() == null)
            post.setId(UUID.randomUUID());
        return this.repository.save(post);
    }

    @Override
    public Post update(Post post) {
        return this.repository.save(post);
    }

    @Override
    public Post partialUpdate(Post post) {
        return  this.repository.save(post);
    }
}
