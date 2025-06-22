package com.bookStore.web;

import com.bookStore.model.binding.ProductAddBingingModel;
import com.bookStore.model.entity.User;
import com.bookStore.model.entity.enums.CategoryName;
import com.bookStore.model.service.ProductServiceModel;
import com.bookStore.service.ProductService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession) {
        if (!model.containsAttribute("productAddBingingModel")) {
            model.addAttribute("productAddBingingModel", new ProductAddBingingModel());
        }
        model.addAttribute("categoryValues", CategoryName.values());
        return "product-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ProductAddBingingModel productAddBingingModel
            , BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddBingingModel", productAddBingingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.productAddBingingModel", bindingResult);
            return "redirect:add";
        }
        productService.add(modelMapper.map(productAddBingingModel, ProductServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/buy/{id}")
    public String buyById(@PathVariable UUID id) {
        productService.buyById(id);
        return "redirect:/";
    }

    @GetMapping("/buy/all")
    public String buyAll() {
        productService.buyAll();
        return "redirect:/";
    }
}
