package com.example.Voiture;

import com.example.Voiture.entities.Client;
import com.example.Voiture.entities.Voiture;
import com.example.Voiture.ClientService;
import com.example.Voiture.repositories.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.example.Voiture")
public class VoitureApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoitureApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner initializeBaseH2(VoitureRepository voitureRepository) {
		return args -> {

			Voiture voiture1 = new Voiture(Long.parseLong("1"), "Toyota", "ABC123", "Corolla", null);
			voitureRepository.save(voiture1);
		};
	}*/
	@Bean
	public CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService clientService) {
		return args -> {
			Client c1 = clientService.clientById(2L);
			Client c2 = clientService.clientById(1L);

			System.out.println("**************************");
			System.out.println("Id est :" + c2.getId());
			System.out.println("Nom est :" + c2.getNom());
			System.out.println("**************************");

			System.out.println("**************************");
			System.out.println("Id est :" + c1.getId());
			System.out.println("Nom est :" + c1.getNom());
			System.out.println("Age est :" + c1.getAge());
			System.out.println("**************************");

			voitureRepository.save(new Voiture(null, "Toyota", "A25 333", "Corolla", c2));
			voitureRepository.save(new Voiture(null, "Renault", "B6 3456", "Megane", c2));
			voitureRepository.save(new Voiture(null, "Peugeot", "A55 4444", "301", c1));
		};
	}


}
