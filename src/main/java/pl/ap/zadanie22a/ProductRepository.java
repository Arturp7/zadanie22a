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

    public int sum(){
        List<Product> products = getAll();
        int price1 = 0;
        int totalPrice = 0;
        for (Product product1 : products) {
            price1 = price1 + product1.getPrice();
        }
        totalPrice = price1;

        return totalPrice;
    }


}
