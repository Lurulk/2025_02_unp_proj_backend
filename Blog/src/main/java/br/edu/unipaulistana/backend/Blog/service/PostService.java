package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> findAll();

    Post findById(UUID id);

    void deleteById(UUID id);

    Post create(Post post);

    Post update(Post post);

    Post partialUpdate(Post post);
}
