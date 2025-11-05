package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.TagC;

import java.util.List;
import java.util.UUID;

public interface TagService {
    List<TagC> findAll();

    TagC findById(UUID id);

    void deleteById(UUID id);

    TagC create(TagC tagC);

    TagC update(TagC tagC);

    TagC partialUpdate(TagC tagC);
}
