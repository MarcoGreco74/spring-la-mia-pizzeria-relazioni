package it.corsospring.spring.spring_la_mia_pizzeria_relazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.corsospring.spring.spring_la_mia_pizzeria_relazioni.model.Ingredienti;



public interface IngredientiPizzaRepository extends JpaRepository<Ingredienti, Integer> {

}
