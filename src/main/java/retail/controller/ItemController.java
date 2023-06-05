package retail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import retail.contract.ItemRequest;
import retail.service.ItemServiceImpl;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemServiceImpl itemService;

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> SaveItem(@RequestBody ItemRequest itemRequest)
    {
        return new ResponseEntity<>(itemService.saveItem(itemRequest), HttpStatus.OK);
    }

    @PutMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> UpdateItem(@RequestBody ItemRequest itemRequest)
    {
        return new ResponseEntity<>(itemService.editItem(itemRequest), HttpStatus.OK);
    }

    @RequestMapping(value = "")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<?> GetItems(Pageable pageable)
    {
        return new ResponseEntity<>(itemService.findAllItems(pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "/{Id}")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<?> GetItemsById(@PathVariable long Id)
    {
        return new ResponseEntity<>(itemService.findById(Id), HttpStatus.OK);
    }

    @RequestMapping(value = "/price/{price}")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<?> GetItemsByPrice(@PathVariable double price,  Pageable pageable)
    {
        return new ResponseEntity<>(itemService.findAllByPrice(price, pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "name/{name}")
    public ResponseEntity<?> GetItemsByName(@PathVariable String name,  Pageable pageable)
    {
        return new ResponseEntity<>(itemService.findAllByName(name, pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "category/{category}")
    public ResponseEntity<?> GetItemsByPrice(@PathVariable String category,  Pageable pageable)
    {
        return new ResponseEntity<>(itemService.findAllByCategory(category, pageable), HttpStatus.OK);
    }

    @DeleteMapping("/{Id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> DeleteItemById(@PathVariable long Id)
    {
        itemService.deleteItemById(Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
