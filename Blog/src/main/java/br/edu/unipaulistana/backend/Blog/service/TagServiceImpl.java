package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.TagC;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TagServiceImpl implements TagService {
    private final TagRepository repository;

    public TagServiceImpl(TagRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TagC> findAll() {
        return this.repository.findAll();
    }

    @Override
    public TagC findById(UUID id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        this.repository.deleteById(id);
    }

    @Override
    public TagC create(TagC tagc) {
        if(tagc.getId() == null)
            tagc.setId(UUID.randomUUID());
        return this.repository.save(tagc);
    }

    @Override
    public TagC update(TagC tagc) {
        return this.repository.save(tagc);
    }

    @Override
    public TagC partialUpdate(TagC tagc) {
        return  this.repository.save(tagc);
    }
}
