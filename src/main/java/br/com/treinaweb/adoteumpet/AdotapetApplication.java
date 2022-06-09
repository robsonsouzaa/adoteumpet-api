package br.com.treinaweb.adoteumpet;

import br.com.treinaweb.adoteumpet.core.models.Pet;
import br.com.treinaweb.adoteumpet.core.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdotapetApplication implements CommandLineRunner {

	@Autowired
	private PetRepository petRepository;

	public static void main(String[] args) {
		SpringApplication.run(AdotapetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var pet = new Pet();

		pet.setName("Golias");
		pet.setDescription("História de mais");
		pet.setImageUrl("https://www.patasdacasa.com.br/noticia/faro-do-cachorro-veja-as-racas-de-porte-pequeno-que-nasceram-para-serem-cacadores_a3441/1");

		petRepository.save(pet);
	}
}
