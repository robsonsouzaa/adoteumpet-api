package br.com.treinaweb.adoteumpet.api.adocao.dtos;

import br.com.treinaweb.adoteumpet.api.pet.dtos.PetResponse;

import java.math.BigDecimal;

public class AdocaoResponse {

    private Long id;

    private String email;

    private BigDecimal ammount;

    private PetResponse pet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getAmmount() {
        return ammount;
    }

    public void setAmmount(BigDecimal ammount) {
        this.ammount = ammount;
    }

    public PetResponse getPet() {
        return pet;
    }

    public void setPet(PetResponse pet) {
        this.pet = pet;
    }
}
