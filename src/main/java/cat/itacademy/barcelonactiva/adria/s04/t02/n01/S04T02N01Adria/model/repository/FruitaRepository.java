package cat.itacademy.barcelonactiva.adria.s04.t02.n01.S04T02N01Adria.model.repository;

import cat.itacademy.barcelonactiva.adria.s04.t02.n01.S04T02N01Adria.model.domain.Fruita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FruitaRepository extends JpaRepository<Fruita, Long> {
    public Optional<Fruita> findByName(String name);
}
