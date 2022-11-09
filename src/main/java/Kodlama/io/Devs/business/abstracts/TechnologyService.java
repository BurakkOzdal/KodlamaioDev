package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import Kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponse;

public interface TechnologyService {
    
    List<GetAllTechnologyResponse> getAll();
    void create (CreateTechnologyRequest createTechnologyRequest) throws Exception;

}
