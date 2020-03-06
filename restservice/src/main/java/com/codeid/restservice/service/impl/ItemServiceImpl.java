package com.codeid.restservice.service.impl;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import com.codeid.restservice.entities.Item;
import com.codeid.restservice.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired //manggil bean nya spring
    private List<Item> entities;

    @PostConstruct
    public void init(){
        add(new Item(0, "Kentang"));
        add(new Item(0, "KentangDulu"));
        add(new Item(0, "KentangLagi"));
        add(new Item(0, "KentangTerus"));
        add(new Item(0, "KentangMulu"));
    }

    public int nextId(){
        int i = 1;
        for (Item entity : entities) {
            if (entity.getId() != i) {
                break;
            }
            i++;
        }
        return i;
    }

    @Override
    public Item add(Item entity) {
        entity.setId(nextId());
        entity.setCreatedDate(LocalDateTime.now());
        entities.add(entity);
        return entity;

    }

    @Override
    public Item edit(Item entity) {
        Item item = findById(entity.getId());
        item.setName(entity.getName());
        item.setModifiedDate(LocalDateTime.now());
        return item;
    }

    @Override
    public Item removeById(Integer id) {
        Iterator<Item> iterator = entities.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getId().equals(id)) {
                iterator.remove();
                return item;
            }
        }
        return null;

    }

    @Override
    public Item findById(Integer id) {
        for (Item item : entities) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;

    }

    @Override
    public List<Item> findAll() {
        return entities;
    }

}