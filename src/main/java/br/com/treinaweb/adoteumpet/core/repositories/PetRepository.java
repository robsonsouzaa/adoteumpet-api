package br.com.treinaweb.adoteumpet.core.repositories;

import br.com.treinaweb.adoteumpet.core.exceptions.PetNotFoundException;
import br.com.treinaweb.adoteumpet.core.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {

    default Pet findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(PetNotFoundException::new);
    }
}
