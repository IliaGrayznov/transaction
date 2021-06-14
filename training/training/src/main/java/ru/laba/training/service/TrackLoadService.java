package ru.laba.training.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.laba.training.persist.CargoRepository;
import ru.laba.training.persist.Model.Cargo;
import ru.laba.training.persist.Model.Truck;
import ru.laba.training.persist.TruckRepository;

import javax.validation.constraints.Null;

@Service
public class TrackLoadService {
    @Autowired
    CargoRepository cargoRepository;
    @Autowired
    TruckRepository truckRepository;
    @Autowired
    CargoService cargoService;
    @Autowired
    TruckService truckService;


    @Transactional(rollbackFor = NullPointerException.class,
            isolation = Isolation.SERIALIZABLE)
    public boolean loading(int idT, int idC) {
        Truck truck = truckRepository.getOne(idT);
        Cargo cargo = cargoRepository.getOne(idC);
        if (truck.getMax_weight()<cargo.getWeight() || cargo.getCount()<1) {
            return false;
        } else {
            truckService.loadingTruck(truck, cargo);
            truckRepository.save(truck);
            if (truck.getID()==4)
                throw new NullPointerException();
            cargoService.loadingCargo(truck, cargo);
            cargoRepository.save(cargo);
            return true;
        }
    }
}