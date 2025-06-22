package com.bookStore.web;

import com.bookStore.model.entity.User;
import com.bookStore.model.entity.enums.CategoryName;
import com.bookStore.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {
        Object user =  httpSession.getAttribute("user");
        model.addAttribute("user",user);
        if (httpSession.getAttribute("user") == null) {
            return "index";
        }
        model.addAttribute("totalSum", this.productService.getTotalSum());
        model.addAttribute("drinks", productService
                .findAllProductsByCategoryName(CategoryName.DRINK));
        model.addAttribute("foods", productService
                .findAllProductsByCategoryName(CategoryName.FOOD));
        model.addAttribute("households", productService
                .findAllProductsByCategoryName(CategoryName.HOUSEHOLD));
        model.addAttribute("others", productService
                .findAllProductsByCategoryName(CategoryName.OTHER));
        return "home";
    }

}
