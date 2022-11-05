package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entity.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository{
	
	List<Language> languages;
	
	
	public InMemoryLanguageRepository() {
		languages=new ArrayList<Language>();
		languages.add(new Language(1,"Java"));
		languages.add(new Language(2,"C#"));
		languages.add(new Language(3,"JavaScript"));
		languages.add(new Language(4,"Python"));
		languages.add(new Language(5,"Kotlin"));
	}

	@Override
	public List<Language> getAll() {
		
		return languages;
	}

	@Override
	public Language getById(int languageId) throws Exception{
		for(Language language:languages) {
			if(language.getId()==languageId) {
				return language;
			}
		}
		throw new Exception("Kayıt bulunamadı!!!");
	}

	@Override
	public void create(Language language) {
		languages.add(language);
		
	}

	@Override
	public void delete(int languageId) throws Exception{
		
		Language toDelete=getById(languageId);
		languages.remove(toDelete);
		
	}

	@Override
	public void update(Language language) throws Exception{
		Language toUpdate =getById(language.getId());
		toUpdate.setName(language.getName());
		
	}

}
