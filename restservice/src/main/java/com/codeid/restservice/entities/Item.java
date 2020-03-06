package com.codeid.restservice.entities;

import javax.persistence.*;

@Table(name = "item")
@Entity
public class Item extends AbstractEntity<Integer>{

    @Id
    private Integer id;

    // @Column(name = "name_item")
    private String name;

    public Item(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(){
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    //     return "Item{" +
    //             "name='" + name + '\'' +
    //             '}';
    // }


    }
