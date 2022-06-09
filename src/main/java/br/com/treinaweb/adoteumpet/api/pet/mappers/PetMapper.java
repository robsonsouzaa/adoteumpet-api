package br.com.treinaweb.adoteumpet.api.pet.mappers;

import br.com.treinaweb.adoteumpet.api.pet.dtos.PetRequest;
import br.com.treinaweb.adoteumpet.api.pet.dtos.PetResponse;
import br.com.treinaweb.adoteumpet.core.models.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    public PetResponse toResponse(Pet pet) {
        var petResponse = new PetResponse();
        petResponse.setId(pet.getId());
        petResponse.setName(pet.getName());
        petResponse.setDescription(pet.getDescription());
        petResponse.setImageUrl(pet.getImageUrl());

        return petResponse;
    }

    public Pet toModel(PetRequest petRequest) {
        var pet = new Pet();
        pet.setName(petRequest.getName());
        pet.setDescription(petRequest.getDescription());
        pet.setImageUrl(petRequest.getImageUrl());

        return pet;
    }
}
