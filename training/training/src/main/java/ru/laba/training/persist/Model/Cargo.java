package ru.laba.training.persist.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false)
    private int ID;


    @Column(name = "name")
    private  String name;

    @Column(name = "weight")
    private  int weight;

    @Column(name = "count")
    private  int count;

    @ManyToMany
    private List<Truck> trucks;

    public Cargo() {
    }

    public Cargo(int ID, String name, int weight, int count, List<Truck> trucks) {
        this.ID = ID;
        this.name = name;
        this.weight = weight;
        this.count = count;
        this.trucks = trucks;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Truck> getTrucks() {
        return trucks;
    }

    public void setTrucks(List<Truck> trucks) {
        this.trucks = trucks;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
