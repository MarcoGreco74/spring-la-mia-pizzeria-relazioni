package it.corsospring.spring.spring_la_mia_pizzeria_relazioni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.corsospring.spring.spring_la_mia_pizzeria_relazioni.model.Pizzeria;

@Repository
public interface PizzeriaRepository extends JpaRepository<Pizzeria, Integer>{

    /*@Query(value = "SELECT * FROM pizzeria WHERE nome = :nome", nativeQuery = true)
        Optional<Pizzeria> trovaPerENome(@Param("nome") String nome);*/
        public List<Pizzeria> findByNomeContainingIgnoreCase(String nome);
        //@Query(value = "SELECT * FROM pizzeria WHERE nome like ?", nativeQuery = true)
       // public List<Pizzeria> findByNome(String nome);
       @Query(value = "SELECT * FROM pizza WHERE descrizione like ?1", nativeQuery = true)
        public List<Pizzeria> findDescrizioneContainingIgnoreCase(String descrizione);
}
