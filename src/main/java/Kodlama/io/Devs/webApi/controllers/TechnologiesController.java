package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import Kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {

    private TechnologyService technologyService;
    
    @Autowired
    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService=technologyService;
    }
    
    
    @GetMapping("/getall")
    public List<GetAllTechnologyResponse> getAll(){
        return this.technologyService.getAll();
    }
    
    @PostMapping("/add")
    public void create(@RequestBody CreateTechnologyRequest createTechnologyRequest) throws Exception{
          this.technologyService.create(createTechnologyRequest);
    }
}
