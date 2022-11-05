package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entity.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<Language> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public Language getById(int languageId) throws Exception {
		return languageRepository.getById(languageId);
	}

	@Override
	public void create(Language language) throws Exception{
		if (language.getName().isEmpty()) {
			throw new Exception("İsim boş bırakılamaz!!!");
		}
		for(Language lng: languageRepository.getAll()) {
			if(lng.getId()==language.getId() || lng.getName()==language.getName()) {
				throw new Exception("Bu isimde kayıt mevcut");
			}
		}
		languageRepository.create(language);
		
	}

	@Override
	public void delete(int languageId) throws Exception {
		languageRepository.delete(languageId);
		
	}

	@Override
	public void update(Language language) throws Exception {
		if(languageRepository.getById(language.getId())==null) {
			throw new Exception("Sisteme kayıtlı bilgi bulunamadı!!!");
		}
		languageRepository.update(language);
		
	}

}
