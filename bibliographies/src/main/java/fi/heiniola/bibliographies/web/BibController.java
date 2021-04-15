package fi.heiniola.bibliographies.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.heiniola.bibliographies.domain.Bib;
import fi.heiniola.bibliographies.domain.BibRepository;
import fi.heiniola.bibliographies.domain.GenreRepository;

@Controller
public class BibController {
	@Autowired
	private BibRepository repository;
	@Autowired
	private GenreRepository genreRepository;

	@RequestMapping(value = { "/", "/home" })
	public String bibList() {
		return "home";
	}

	@RequestMapping(value = { "/biblist" })
	public String bibList(Model model) {
		model.addAttribute("bibs", repository.findAll());
		return "biblist";
	}

	@RequestMapping(value="/addbib", method=RequestMethod.GET)
	public String addBib(Model model) {
		model.addAttribute("bib", new Bib());
		model.addAttribute("genres", genreRepository.findAll());
		return "addBib";
	}

	@RequestMapping(value="/addbib", method=RequestMethod.POST)
	public String BibSa(@Valid Bib bib, BindingResult bindingResult, Model model) {
		model.addAttribute("genres", genreRepository.findAll());
		 if (bindingResult.hasErrors()) {
		
		return "addBib";
	}
		 repository.save(bib);
		 return "redirect:biblist";
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteBib(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:/biblist";
	}
	
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/editBib/{id}", method=RequestMethod.GET)
    public String editbib(@PathVariable("id") Long bibId, Model model) {
        model.addAttribute("bib", repository.findById(bibId));
        model.addAttribute("genres", genreRepository.findAll());
        return "editBib";
        
    }

	@RequestMapping(value="/editBib/{id}", method=RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
    public String editbib(@Valid Bib bib, BindingResult bindingResult, Model model) {
        model.addAttribute("genres", genreRepository.findAll());
        if (bindingResult.hasErrors()) {
        return "editBib";
        }
      
          repository.save(bib);
          return "redirect:../biblist";
        }
}
