package com.ironyard.desserts.data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sam on 10/24/16.
 */
@Entity
public class Friend {

    private String name;
    private String allergies;
    private boolean sleepover;
    private String birthday;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Desserts> desserts;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public boolean isSleepover() {
        return sleepover;
    }

    public void setSleepover(boolean sleepover) {
        this.sleepover = sleepover;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Desserts> getDesserts() {
        return desserts;
    }

    public void setDesserts(List<Desserts> desserts) {
        this.desserts = desserts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
