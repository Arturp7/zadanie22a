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


    @RequestMapping("/dodaj")
    public String addproduct(@RequestParam String name, @RequestParam int price) {
        Product product = new Product(name, price);
        productRepository.add(product);
        return "redirect:/lista";

    }
    @GetMapping("/tabela")
    public String showTable(Model model){
        List<Product> products = productRepository.getAll();
        int totalPrice= productRepository.sum();
        model.addAttribute("products", products);
        model.addAttribute("price", totalPrice);
        return "table";
    }
    @GetMapping("/lista")
    public String showList(Model model){
       List<Product> products = productRepository.getAll();
       int totalPrice= productRepository.sum();

        model.addAttribute("products", products);
        model.addAttribute("price", totalPrice);
        return "lista";
    }



}