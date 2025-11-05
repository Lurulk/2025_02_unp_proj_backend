package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Profile;

import java.util.List;
import java.util.UUID;

public interface ProfileService {
    List<Profile> findAll();

    Profile findById(UUID id);

    void deleteById(UUID id);

    Profile create(Profile profile);

    Profile update(Profile profile);

    Profile partialUpdate(Profile profile);
}
