package Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.entity.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer>{
	
}
