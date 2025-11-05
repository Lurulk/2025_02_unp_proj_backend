package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Role;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Role> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Role findById(UUID id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        this.repository.deleteById(id);
    }

    @Override
    public Role create(Role role) {
        if(role.getId() == null)
            role.setId(UUID.randomUUID());
        return this.repository.save(role);
    }

    @Override
    public Role update(Role role) {
        return this.repository.save(role);
    }

    @Override
    public Role partialUpdate(Role role) {
        return  this.repository.save(role);
    }
}
