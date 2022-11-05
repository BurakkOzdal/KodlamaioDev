package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Devs.entity.concretes.Language;

public interface LanguageRepository {
	
	List<Language> getAll();
	Language getById(int languageId) throws Exception;
	void create(Language language) ;
	void delete (int languageId) throws Exception ;
	void update (Language language) throws Exception;
	
}
