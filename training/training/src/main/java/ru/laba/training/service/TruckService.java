package ru.laba.training.service;
import org.springframework.stereotype.Service;
import ru.laba.training.persist.Model.Cargo;
import ru.laba.training.persist.Model.Truck;

import java.util.ArrayList;
import java.util.List;

@Service
public class TruckService {

    public boolean loadingTruck(Truck truck, Cargo cargo) {
        List<Cargo> cargos = new ArrayList<Cargo>();
        cargos.add(cargo);
        if (truck.getLoad() == null)
            truck.setLoad(cargos);
        else
            truck.getLoad().add(cargo);
        return true;
    }
}
