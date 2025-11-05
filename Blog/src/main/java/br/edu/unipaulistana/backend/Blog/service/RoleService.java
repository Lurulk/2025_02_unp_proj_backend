package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Role;

import java.util.List;
import java.util.UUID;

public interface RoleService {
    List<Role> findAll();

    Role findById(UUID id);

    void deleteById(UUID id);

    Role create(Role role);

    Role update(Role role);

    Role partialUpdate(Role role);
}
