package ru.laba.training.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.laba.training.persist.Model.Exercise;
import ru.laba.training.persist.Model.Truck;

import java.util.List;

public interface TruckRepository extends JpaRepository<Truck, Integer> {
    @Query("select t from Truck t where t.max_weight>=(select max(c.weight) from Cargo c)")
    List<Truck> findTruckForMostHeavyCargo();
}
