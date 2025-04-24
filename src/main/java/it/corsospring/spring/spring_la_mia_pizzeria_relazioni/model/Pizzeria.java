package it.corsospring.spring.spring_la_mia_pizzeria_relazioni.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="pizza")
public class Pizzeria {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message="Il nome è obbligatorio")
    private String nome;

    @NotBlank(message="La descrizione è obbligatoria")
    private String descrizione;

    @NotNull
    private String foto;

    @Min(value=4, message="Il prezzo deve essere non inferiore ad €4")
    private int prezzo;

    @OneToMany(mappedBy = "pizzeria")
     private List<OffertePizza> offertePizza;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public List<OffertePizza> getOffertePizza() {
        return offertePizza;
    }

    public void setOffertePizza(List<OffertePizza> offertePizza) {
        this.offertePizza = offertePizza;
    }


}

