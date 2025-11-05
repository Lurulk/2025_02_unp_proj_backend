package br.edu.unipaulistana.backend.Blog.service;

import br.edu.unipaulistana.backend.Blog.domainmodel.Profile;
import br.edu.unipaulistana.backend.Blog.domainmodel.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository repository;

    public ProfileServiceImpl(ProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Profile> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Profile findById(UUID id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        this.repository.deleteById(id);
    }

    @Override
    public Profile create(Profile profile) {
        if(profile.getId() == null)
            profile.setId(UUID.randomUUID());
        return this.repository.save(profile);
    }

    @Override
    public Profile update(Profile profile) {
        return this.repository.save(profile);
    }

    @Override
    public Profile partialUpdate(Profile profile) {
        return  this.repository.save(profile);
    }
}
