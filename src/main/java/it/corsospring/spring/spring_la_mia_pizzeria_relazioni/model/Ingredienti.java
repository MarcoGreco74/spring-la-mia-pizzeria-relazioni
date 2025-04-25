package it.corsospring.spring.spring_la_mia_pizzeria_relazioni.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Ingredienti {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer id;
        
        @NotBlank(message="Campo obbligatorio")
        private String ingredienti;

        @ManyToMany(mappedBy="ingredientiPizza")
        @JsonBackReference
        private List<Pizzeria> pizzeria;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getIngredienti() {
            return ingredienti;
        }

        public void setIngredienti(String ingredienti) {
        this.ingredienti = ingredienti;
    }

        public List<Pizzeria> getPizzeria() {
            return pizzeria;
        }

        public void setPizzeria(List<Pizzeria> pizzeria) {
            this.pizzeria = pizzeria;
        }

}
