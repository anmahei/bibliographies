package fi.heiniola.bibliographies;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.heiniola.bibliographies.domain.Genre;
import fi.heiniola.bibliographies.domain.GenreRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class GenreRepositoryTest {

	@Autowired
	GenreRepository genreRepository;

	@Test
	public void findByGenreNameShouldReturnGenreId() {
		List<Genre> genres = genreRepository.findByName("no genre");
		assertThat(genres.get(0).getId()).isEqualTo(1);
	}

	@Test
	public void createNewGenre() {
		Genre Genre = new Genre("Testaus");
		genreRepository.save(Genre);
		assertThat(Genre.getId()).isNotNull();
	}

}
