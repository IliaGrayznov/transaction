package ru.laba.training.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.laba.training.persist.Model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
}
