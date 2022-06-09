package br.com.treinaweb.adoteumpet.api.pet.validators;

import br.com.treinaweb.adoteumpet.core.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PetExistsByIdValidator implements ConstraintValidator<PetExistsById, Long> {

    @Autowired
    PetRepository petRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if(value == null) {
            return true;
        }

        return petRepository.existsById(value);
    }
}
