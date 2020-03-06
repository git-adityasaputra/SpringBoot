package com.codeid.restservice.controller;

import com.codeid.restservice.entities.Item;
import com.codeid.restservice.models.ResponseMessage;
import com.codeid.restservice.service.ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/items")
@RestController
public class ItemController {


    @Autowired
    private ItemService ItemService;
    
    @PostMapping
    public ResponseMessage<Item> add(@RequestBody Item item) {
        Item addedItem = ItemService.add(item);
        return ResponseMessage.success(addedItem);
    }

    @PutMapping("/{id}")
    public ResponseMessage<Item> edit(@PathVariable Integer id, @RequestBody Item item) {
        item.setId(id);
        Item editedItem = ItemService.edit(item);
        if (editedItem != null) {
            return ResponseMessage.success(editedItem);
        } else{
        return ResponseMessage.error(1, "Data Not Found");
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseMessage<Item> removeById(@PathVariable Integer id){
        Item item = ItemService.removeById(id);
        if (item != null) {
            return ResponseMessage.success(item);
        } else{
        return ResponseMessage.error(1, "Data Not Found");
        }
    } 

    @GetMapping("/{id}")
    public ResponseMessage<Item> findById(@PathVariable Integer id) {
        Item item = ItemService.findById(id);
        if (item != null) {
            return ResponseMessage.success(item);
        } else{
        return ResponseMessage.error(1, "Data Not Found");
        }
    }

    @GetMapping()
    public ResponseMessage<List<Item>> findAll() {
        List<Item> items = ItemService.findAll();
        return ResponseMessage.success(items);
    }
}