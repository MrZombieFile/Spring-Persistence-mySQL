package cat.itacademy.barcelonactiva.adria.s04.t02.n01.S04T02N01Adria.service;

import cat.itacademy.barcelonactiva.adria.s04.t02.n01.S04T02N01Adria.entity.Fruita;

import java.util.Optional;

public interface FruitaService {

    public Iterable<Fruita> findAll();

    public Optional<Fruita> findById(Long id);

    public String deleteById(Long id);

    public Fruita save(Fruita fruita);


}
