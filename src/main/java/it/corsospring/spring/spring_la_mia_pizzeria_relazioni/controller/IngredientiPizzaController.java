package it.corsospring.spring.spring_la_mia_pizzeria_relazioni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corsospring.spring.spring_la_mia_pizzeria_relazioni.model.Ingredienti;
import it.corsospring.spring.spring_la_mia_pizzeria_relazioni.model.Pizzeria;
import it.corsospring.spring.spring_la_mia_pizzeria_relazioni.repository.IngredientiPizzaRepository;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/ingredienti")
public class IngredientiPizzaController {

    @Autowired
    private IngredientiPizzaRepository ingredientiRepository;

    @GetMapping()
    public String ingredienti(Model model) {
        model.addAttribute("ingredientiList", ingredientiRepository.findAll());
        model.addAttribute("ingredientiObj", new Ingredienti());
        return "/ingredienti/ingredientiPizza";
    }
    
    @PostMapping("/create")
    public String crea(@Valid @ModelAttribute("ingredientiObj") Ingredienti formIngredienti, BindingResult bindingResult) {
        if(!bindingResult.hasErrors()){
            ingredientiRepository.save(formIngredienti);
        }
        return "redirect:/ingredienti";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Ingredienti ing = ingredientiRepository.findById(id).get();
        for(Pizzeria piz : ing.getPizzeria()){
            piz.getIngredientiPizza().remove(ing);
        }
        ingredientiRepository.deleteById(id);
        return "redirect:/ingredienti";
    }
    
}
