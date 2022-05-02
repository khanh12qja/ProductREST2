package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController

public class ProductController {
    @Autowired
    private  ProductService service;
    @GetMapping("/products")
    public List<Product> list(){
        return  service.listALL();
    }
    @GetMapping("/products/{id}")
public ResponseEntity<Product>  get(@PathVariable Integer id){
        try{
            Product product =service.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);

        }catch ( NoSuchElementException e){
            return new ResponseEntity<Product>(HttpStatus.FOUND);
        }




    }
    @PostMapping("/products")
    public void add(Product product){
        service.save(product);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<?> update(@RequestBody Product product,
        @PathVariable Integer id) {
        try{
        Product exProduct=service.get(id);

    service.save(product);
    return  new ResponseEntity<>(HttpStatus.OK);

        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
    @DeleteMapping("/prducts/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
