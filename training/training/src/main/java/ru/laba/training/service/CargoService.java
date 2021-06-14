package ru.laba.training.service;
import org.springframework.stereotype.Service;
import ru.laba.training.persist.Model.Cargo;
import ru.laba.training.persist.Model.Truck;

import java.util.ArrayList;
import java.util.List;

@Service
public class CargoService {

    public boolean loadingCargo(Truck truck, Cargo cargo) {
        cargo.setCount(cargo.getCount()-1);
        List<Truck> trucks = new ArrayList<Truck>();
        trucks.add(truck);
        if (cargo.getTrucks() == null)
            cargo.setTrucks(trucks);
        else
            cargo.getTrucks().add(truck);
        return true;
    }
}
