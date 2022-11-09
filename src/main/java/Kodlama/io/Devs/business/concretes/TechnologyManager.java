package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import Kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponse;
import Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.entity.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{
    private TechnologyRepository technologyRepository;
    
    @Autowired
    public TechnologyManager(TechnologyRepository technologyRepository) {
        this.technologyRepository=technologyRepository;
    }

    @Override
    public List<GetAllTechnologyResponse> getAll() {
        List<Technology> technologies=this.technologyRepository.findAll();
        List<GetAllTechnologyResponse> techResponse =new ArrayList<GetAllTechnologyResponse>();
        
        for (Technology technology : technologies) {
            GetAllTechnologyResponse response = new GetAllTechnologyResponse();
            response.setName(technology.getName());
            response.setId(technology.getId());
            techResponse.add(response);
        }
        
        return techResponse;
        
    }

    @Override
    public void create(CreateTechnologyRequest createTechnologyRequest)throws Exception {
       Technology toSave=new Technology();
       
           if (createTechnologyRequest.getName().isEmpty()) {
            throw new Exception("İsim boş bırakılamaz!!! ");
        }
           for (Technology technology : this.technologyRepository.findAll()) {
            if(createTechnologyRequest.getName().equalsIgnoreCase(technology.getName())) {
                throw new Exception("Kayıt Mevcut!!! ");
            }
        }
           toSave.setName(createTechnologyRequest.getName());
           toSave.getLanguage().setId(createTechnologyRequest.getLanguageId());
           this.technologyRepository.save(toSave);
        
    }

}
