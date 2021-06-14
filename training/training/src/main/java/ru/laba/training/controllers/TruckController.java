package ru.laba.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.laba.training.persist.CargoRepository;
import ru.laba.training.persist.RoleRepository;
import ru.laba.training.persist.TruckRepository;
import ru.laba.training.service.TrackLoadService;
import ru.laba.training.service.TruckService;
import ru.laba.training.service.UserRepr;
import ru.laba.training.service.UserService;

import javax.validation.Valid;

@Controller
public class TruckController {

    private final UserService userService;
    private TruckRepository truckRepository;

    @Autowired
    TrackLoadService trackLoadService;
    @Autowired
    CargoRepository cargoRepository;

    @Autowired
    public TruckController(UserService userService, TruckRepository truckRepository) {
        this.userService = userService;
        this.truckRepository = truckRepository;
    }


    @GetMapping("/truck")
    public String LoginPage(Model model) {
        model.addAttribute("trucks", truckRepository.findTruckForMostHeavyCargo());
        return "TruckPage";
    }

    @PostMapping("/{id}/deleteTruck")
    public String autoP(@PathVariable("id") int id){
        truckRepository.deleteById(id);
        return "redirect:/truck";
    }

    @GetMapping("/load")
    public String load(Model model) {
        model.addAttribute("trucks", truckRepository.findAll());
        model.addAttribute("cargo", cargoRepository.findAll());
        return "loadPage";
    }

    @PostMapping("/loadP")
    public String loadP(@ModelAttribute("id_truck") int id_truck, @ModelAttribute("id_cargo") int id_cargo){
        trackLoadService.loading(id_truck, id_cargo);
        return "redirect:/truck";
    }
}
