package com.codeid.restservice.entities;


import javax.persistence.*;

@Entity
@Table(name = "stock")
public class Stock extends AbstractEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int quantity;

    @ManyToOne
    @JoinColumn ( nullable = false)
    private Unit unit;

    @ManyToOne
    @JoinColumn (nullable = false)
    private Item item;

    public Stock() { }

    public Stock(int quantity, Unit unit, Item item) {
        this.quantity = quantity;
        this.unit = unit;
        this.item = item;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getId_item() {
        return item;
    }

    public void setId_item(Item unit) {
        this.item = item;
    }

    public Unit getId_unit() {
        return unit;
    }

    public void setId_unit(Unit id_unit) {
        this.unit = unit;
    }
    
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", unit='" + getId_unit() + "'" +
            ", item='" + getId_item() + "'" +
            "}";
    }


    // @Override
    // public String toString() {
    //     return "Stock{" +
    //             "id=" + id +
    //             ", quantity=" + quantity +
    //             ", unit=" + unit +
    //             ", item=" + item +
    //             '}';
    // }
}
