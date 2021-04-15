package fi.heiniola.bibliographies.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.heiniola.bibliographies.domain.Bib;
import fi.heiniola.bibliographies.domain.BibRepository;
import fi.heiniola.bibliographies.domain.Genre;
import fi.heiniola.bibliographies.domain.GenreRepository;

@RestController
public class RestBibController {
	
	@Autowired
	private BibRepository repository;
	@Autowired
	private GenreRepository genreRepository;
	
    @RequestMapping("/bibs")
    public List <Bib>bibListRest() {
        return (List<Bib>) repository.findAll();
    }
    
    @RequestMapping("/genres")
    public List <Genre> genreListRest() {	
        return (List<Genre>) genreRepository.findAll();
    }

    
}
