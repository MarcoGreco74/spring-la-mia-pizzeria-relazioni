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

import it.corsospring.spring.spring_la_mia_pizzeria_relazioni.model.OffertePizza;
import it.corsospring.spring.spring_la_mia_pizzeria_relazioni.repository.OffertaPizzaRepository;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/offerta")
public class OffertaPizzaController {

    @Autowired
    private OffertaPizzaRepository repositoryOfferta;

    @PostMapping("/create")
    public String storeOfferta(@Valid @ModelAttribute("offertaPizza") OffertePizza formOffertaPizza, 
        BindingResult bindingResult,
        Model model){       
            if(bindingResult.hasErrors()){
                model.addAttribute("editMode", false);
                model.addAttribute("offertaPizza", formOffertaPizza);
                return "/offerte/edit";
            }  
            repositoryOfferta.save(formOffertaPizza);
            return "redirect:/pizzeria/show_id/" + formOffertaPizza.getPizzeria().getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        OffertePizza offerta = repositoryOfferta.findById(id).get();
        model.addAttribute("offertaPizza", offerta);
        model.addAttribute("editMode", true);
        return "/offerte/edit";
    }

    @PostMapping("/edit/{id}")
    public String doEdit(@Valid @ModelAttribute("offerta") OffertePizza offerta,
    BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("editMode", true);
            model.addAttribute("offertaPizza", offerta);
            return "/offerte/edit";
        }
        repositoryOfferta.save(offerta);
        return "redirect:/pizzeria/show_id/"+offerta.getPizzeria().getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        repositoryOfferta.deleteById(id);
        return "redirect:/pizzeria";
    }
    
}
