package br.com.treinaweb.adoteumpet.api.adocao.dtos;

import br.com.treinaweb.adoteumpet.api.pet.validators.PetExistsById;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@JsonNaming(SnakeCaseStrategy.class)
public class AdocaoRequest {

    @NotNull
    @Email
    @Size(max = 255)
    @NotEmpty
    private String email;

    @NotNull
    @Min(10)
    @Max(100)
    private BigDecimal amount;

    @NotNull
    @Positive
    @PetExistsById
    private Long petId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }
}
