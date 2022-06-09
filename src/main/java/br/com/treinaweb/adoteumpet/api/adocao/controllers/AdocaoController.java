package br.com.treinaweb.adoteumpet.api.adocao.controllers;

import br.com.treinaweb.adoteumpet.api.adocao.dtos.AdocaoRequest;
import br.com.treinaweb.adoteumpet.api.adocao.dtos.AdocaoResponse;
import br.com.treinaweb.adoteumpet.api.adocao.services.AdocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/adocoes")
public class AdocaoController {

   @Autowired
   private AdocaoService adocaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AdocaoResponse create(@RequestBody @Valid AdocaoRequest adocaoRequest) {
        return adocaoService.create(adocaoRequest);
    }

    @GetMapping
    public List<AdocaoResponse> findAll() {
        return adocaoService.findAll();
    }
}
