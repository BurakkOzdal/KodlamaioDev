package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.entity.concretes.Language;

public interface LanguageService {
	
	List<Language> getAll();
	Language getById(int languageId) throws Exception;
	void create(Language language) throws Exception ;
	void delete (int languageId) throws Exception ;
	void update (Language language) throws Exception;

}
