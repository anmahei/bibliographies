package fi.heiniola.bibliographies.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BibRepository extends CrudRepository<Bib, Long> {
	
	
	List<Bib> findByAuthor(String author);
	List<Bib> findByTitle(String title);

}
