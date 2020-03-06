package com.codeid.restservice.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "unit")
@Entity
public class Unit extends AbstractEntity<Integer>{

    @Id
    private Integer id;

    @Column (name = "name_unit")
    private String name;

    public Unit(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Unit() {
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName_unit() {
        return name;
    }

    public void setName_unit(String name_unit) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }


    // @Override
    // public String toString() {
    //     return "Unit{" +
    //             "name='" + name + '\'' +
    //             '}';
    // }

}
