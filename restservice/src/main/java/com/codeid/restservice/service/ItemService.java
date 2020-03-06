package com.codeid.restservice.service;

import java.util.List;

import com.codeid.restservice.entities.Item;

public interface ItemService {

    public Item add(Item entity);
    
    public Item edit(Item entity);

    public Item removeById(Integer id); 

    public Item findById(Integer id);

    public List<Item> findAll();
}