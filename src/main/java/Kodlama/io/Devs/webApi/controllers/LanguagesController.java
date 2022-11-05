package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.entity.concretes.Language;

@RestController
@RequestMapping("/api/language")
public class LanguagesController {

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	
	@GetMapping("/getall")
	public List<Language> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/getbyid")
	public Language getById(@RequestParam int id) throws Exception {
		return languageService.getById(id);
	}
	
	@PostMapping("/add")
	public void createLanguage(@RequestBody Language language) throws Exception {
		 this.languageService.create(language);
	}
	
	@DeleteMapping("/delete")
	public void deleteLanguage(@RequestParam int id) throws Exception{
		this.languageService.delete(id);
	}
	
	@PostMapping("/update")
	public void updateLanguage(@RequestBody Language language) throws Exception{
		this.languageService.update(language);
	}
}
