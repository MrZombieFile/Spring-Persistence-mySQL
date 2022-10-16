package cat.itacademy.barcelonactiva.adria.s04.t02.n01.S04T02N01Adria.model.services;

import cat.itacademy.barcelonactiva.adria.s04.t02.n01.S04T02N01Adria.model.domain.Fruita;
import cat.itacademy.barcelonactiva.adria.s04.t02.n01.S04T02N01Adria.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class FruitaServiceImpl implements FruitaService{

    @Autowired
    FruitaRepository fruitaRepository;


    @Override
    public Iterable<Fruita> findAll() {
        return fruitaRepository.findAll();
    }

    @Override
    public Optional<Fruita> findById(Long id) {
        return fruitaRepository.findById(id);
    }

    public Optional<Fruita> findByName(String name){
        return fruitaRepository.findByName(name);
    }

    @Override
    public String deleteById(Long id) {
        fruitaRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Fruita save(Fruita fruita) {
        return fruitaRepository.save(fruita);
    }
}





