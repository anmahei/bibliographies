package fi.heiniola.bibliographies;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.heiniola.bibliographies.domain.AppUser;
import fi.heiniola.bibliographies.domain.AppUserRepository;
import fi.heiniola.bibliographies.domain.Bib;
import fi.heiniola.bibliographies.domain.BibRepository;
import fi.heiniola.bibliographies.domain.Genre;
import fi.heiniola.bibliographies.domain.GenreRepository;


@SpringBootApplication
public class BibliographiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliographiesApplication.class, args);
	}

	@Bean
	public CommandLineRunner bibDemo(BibRepository bRepository, 
			GenreRepository gRepository, AppUserRepository userRepository) {
		return (args) -> {

			
			gRepository.save(new Genre("no genre"));
			gRepository.save(new Genre("scifi"));
			gRepository.save(new Genre("horror"));
			gRepository.save(new Genre("romantic"));
			gRepository.save(new Genre("young adults"));

			

			System.out.println("fetch all genres");
			for (Genre genre : gRepository.findAll()) {
				System.out.println(genre.getName());
			}

			System.out.println("fetch all bibs");
			for (Bib bib : bRepository.findAll()) {
				System.out.println(bib.toString());
			}


			AppUser user1 = new AppUser("user", "$2a$10$eBe.euY5ukBOCZY1g5psEuXC3hfOith5ksx41lWTn9l.Faq1xBQCu", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$S5JgORJQ9HE/lfsIypI8E.677KVfSJ.trviQ.ktL4licqvkJGEeUu", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
		};
	}
}
