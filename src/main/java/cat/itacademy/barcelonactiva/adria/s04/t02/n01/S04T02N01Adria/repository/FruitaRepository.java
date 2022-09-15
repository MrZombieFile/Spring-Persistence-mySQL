package cat.itacademy.barcelonactiva.adria.s04.t02.n01.S04T02N01Adria.repository;

import cat.itacademy.barcelonactiva.adria.s04.t02.n01.S04T02N01Adria.entity.Fruita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FruitaRepository extends JpaRepository<Fruita, Long> {
    public Optional<Fruita> findByName(String name);
}
