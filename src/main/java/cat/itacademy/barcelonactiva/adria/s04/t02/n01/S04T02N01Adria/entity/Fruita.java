package cat.itacademy.barcelonactiva.adria.s04.t02.n01.S04T02N01Adria.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fruites")
public class Fruita implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private int quantityKilos;

    public Fruita(){

    }

    public Fruita(String name, int quantityKilos){
        this.name = name;
        this.quantityKilos = quantityKilos;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityKilos() {
        return quantityKilos;
    }

    public void setQuantityKilos(int quantityKilos) {
        this.quantityKilos = quantityKilos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
