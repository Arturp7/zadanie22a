package pl.ap.zadanie22a;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {


    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @RequestMapping("/table")
    public String addproduct(@RequestParam String name, @RequestParam int price, Model model) {
        Product product = new Product(name, price);
        productRepository.add(product);
        List<Product> products = productRepository.getAll();

        int price1 = 0;
        int totalPrice = 0;
        for (Product product1 : products) {
            price1 = price1 + product1.getPrice();
        }
        totalPrice = price1;
        model.addAttribute("products",products);
        model.addAttribute("price",totalPrice);
        return "table" ;

    }





}