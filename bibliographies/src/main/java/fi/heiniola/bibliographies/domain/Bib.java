package fi.heiniola.bibliographies.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;



@Entity
public class Bib {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	 @NotEmpty(message = "Name is mandatory")
	private String author;
	private String title, materialtype;
	@NotNull
	@Size(min=3, max=3)
	private String lang;
	private int many;
	
	
	@ManyToOne
	@JoinColumn(name="genreid")
	Genre genre; 	
	
	public Bib() {
		super();
		
	}

	public Bib(String author, String title, String materialtype, String lang, int many) {
		super();
		this.author = author;
		this.title = title;
		this.materialtype = materialtype;
		this.lang = lang;
		this.many = many;
	}

	
	public Bib(String author, String title, String materialtype, String lang, int many, Genre genre) {
		super();
		this.author = author;
		this.title = title;
		this.materialtype = materialtype;
		this.lang = lang;
		this.many = many;
		this.genre = genre;
		
	}
	public int getMany() {
		return many;
	}

	public void setMany(int many) {
		this.many = many;
	}

	public String getMaterialtype() {
		return materialtype;
	}

	public void setMaterialtype(String materialtype) {
		this.materialtype = materialtype;
	}
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + ", materialtype=" + materialtype + ", lang=" + lang + ", many=" + many
			
				+ "]";
	}

}
