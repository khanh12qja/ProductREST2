package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service

public class ProductService {
    @Autowired
    private  ProductRepository repo;
 public List<Product> listALL(){
     return repo.findAll();


 }
 public void save(Product product){
     repo.save(product);
 }
 public  Product get(Integer id){
     return repo.findById(id).get();

 }
 public void delete(Integer id){
     repo.deleteById(id);
 }

}
