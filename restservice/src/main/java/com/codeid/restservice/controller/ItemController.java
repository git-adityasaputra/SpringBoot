    package com.codeid.restservice.controller;

    import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

    import javax.annotation.PostConstruct;

    import com.codeid.restservice.entities.Item;
    import com.codeid.restservice.models.ResponseMessage;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Qualifier;
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

        @Autowired //mencari bean yang setipe -> baca tipenya bukan name
        @Qualifier("itemsBean")
        private List<Item> items;

        @PostMapping
        public ResponseMessage<Item> add(@RequestBody Item item){
            item.setId(items.size() + 1 );
            items.add(item);
            
            return ResponseMessage.success(item);
        }

        @PutMapping("/{id}")
        public ResponseMessage<Item> edit (@PathVariable Integer id, @RequestBody Item item){
            for (Item i : items) {
                if (i.getId().equals(id)) {
                    i.setName(item.getName());
                    return ResponseMessage.success(i);
                }
            }
            return ResponseMessage.error(1, "Data not found.");
        }

        @DeleteMapping("/{id}")
        public ResponseMessage<Item> remove(@PathVariable Integer id){
            Iterator<Item> iterator = items.iterator();
            while (iterator.hasNext()) {
                Item item = iterator.next();
                if (item.getId().equals(id)) {
                    iterator.remove();
                    return ResponseMessage.success(item);
                }
            }
            return ResponseMessage.error(1, "Data not found.");
        }

        @GetMapping("/{id}")
        public ResponseMessage <Item> findById(@PathVariable Integer id) {
            for (Item item : items) {
                if (item.getId().equals(id)) {
                    return ResponseMessage.success(item);
                }
            }
            return ResponseMessage.error(1, "Data not found.");
        }

        @GetMapping
        public ResponseMessage <List<Item>> findAll() {
            return ResponseMessage.success(items);
        }
    }