package br.com.treinaweb.adoteumpet.api.pet.services;

import br.com.treinaweb.adoteumpet.api.pet.dtos.PetRequest;
import br.com.treinaweb.adoteumpet.api.pet.dtos.PetResponse;
import br.com.treinaweb.adoteumpet.api.pet.mappers.PetMapper;
import br.com.treinaweb.adoteumpet.core.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    @Autowired
    PetMapper petMapper;

    public List<PetResponse> findAll() {
        return petRepository.findAll()
                .stream()
                .map(petMapper::toResponse)
                .collect(Collectors.toList());
    }

    public PetResponse create(PetRequest petRequest) {
        var petToCreate = petMapper.toModel(petRequest);
        var createdPet = petRepository.save(petToCreate);

        return petMapper.toResponse(createdPet);
    }
}
