package it.corsospring.spring.spring_la_mia_pizzeria_relazioni.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.corsospring.spring.spring_la_mia_pizzeria_relazioni.model.Pizzeria;
import it.corsospring.spring.spring_la_mia_pizzeria_relazioni.repository.IngredientiPizzaRepository;
import it.corsospring.spring.spring_la_mia_pizzeria_relazioni.repository.OffertaPizzaRepository;
import it.corsospring.spring.spring_la_mia_pizzeria_relazioni.repository.PizzeriaRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/pizzeria")
public class PizzeriaRestController {

    private PizzeriaRepository pizzeriaRepository;
    private OffertaPizzaRepository repositoryOfferta;
    private IngredientiPizzaRepository ingredientiRepository;

    @Autowired
    public PizzeriaRestController(PizzeriaRepository pizzeriaRepository, OffertaPizzaRepository repositoryOfferta, IngredientiPizzaRepository ingredientiRepository ){
        this.pizzeriaRepository = pizzeriaRepository;
        this.repositoryOfferta = repositoryOfferta;
        this.ingredientiRepository = ingredientiRepository;
    }

    @GetMapping
    public List<Pizzeria> index(Model model, @RequestParam(value="keyword", required=false) String nome){
        List<Pizzeria> result;
        if(nome != null  && !nome.isBlank()){
            result = pizzeriaRepository.findByNomeContainingIgnoreCase(nome);
        }else{
           result = pizzeriaRepository.findAll();
          }
        return result;
    }

    @PostMapping
    public Pizzeria create(@Valid @RequestBody Pizzeria pizza){

        return pizzeriaRepository.save(pizza);
    }

    @PutMapping("/{id}")
    public Pizzeria aggiorna(@PathVariable Integer id, @RequestBody Pizzeria pizza) {
        return pizzeriaRepository.save(pizza);
    }

}
