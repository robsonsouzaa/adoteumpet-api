package br.com.treinaweb.adoteumpet.api.adocao.mappers;

import br.com.treinaweb.adoteumpet.api.adocao.dtos.AdocaoRequest;
import br.com.treinaweb.adoteumpet.api.adocao.dtos.AdocaoResponse;
import br.com.treinaweb.adoteumpet.api.pet.mappers.PetMapper;
import br.com.treinaweb.adoteumpet.core.models.Adocao;
import br.com.treinaweb.adoteumpet.core.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdocaoMapper {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetMapper petMapper;

    public Adocao toModel(AdocaoRequest adocaoRequest) {
        var adocao = new Adocao();
        adocao.setEmail(adocaoRequest.getEmail());
        adocao.setAmmount(adocaoRequest.getAmmount());

        adocao.setPet(petRepository.findByIdOrElseThrow(adocaoRequest.getPetId()));

        return adocao;
    }

    public AdocaoResponse toResponse(Adocao adocao) {
        var adocaoResponse = new AdocaoResponse();

        adocaoResponse.setId(adocao.getId());
        adocaoResponse.setEmail(adocao.getEmail());
        adocaoResponse.setAmmount(adocao.getAmmount());
        adocaoResponse.setPet(petMapper.toResponse(adocao.getPet()));

        return adocaoResponse;
    }
}
