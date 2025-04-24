package it.corsospring.spring.spring_la_mia_pizzeria_relazioni.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OffertePizza {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NonNull
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private LocalDate offertaInizio;

    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private LocalDate offertaFine;

    private String titolo;

    @ManyToOne
    @JoinColumn(name="pizza_id", nullable=false)
    private Pizzeria pizzeria;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Pizzeria getPizzeria() {
        return pizzeria;
    }
    public void setPizzeria(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }
    public LocalDate getOffertaInizio() {
        return offertaInizio;
    }
    public void setOffertaInizio(LocalDate offertaInizio) {
        this.offertaInizio = offertaInizio;
    }
    public LocalDate getOffertaFine() {
        return offertaFine;
    }
    public void setOffertaFine(LocalDate offertaFine) {
        this.offertaFine = offertaFine;
    }
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    
}
