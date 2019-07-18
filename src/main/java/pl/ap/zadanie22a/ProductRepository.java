package pl.ap.zadanie22a;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    List<Product> productsList = new ArrayList<>();

    public List<Product> getAll(){
        return productsList;
    }

    public void add(Product product){
        productsList.add(product);
    }


}
