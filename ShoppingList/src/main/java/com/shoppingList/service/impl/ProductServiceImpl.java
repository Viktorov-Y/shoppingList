package com.bookStore.service.impl;

import com.bookStore.model.entity.Product;
import com.bookStore.model.entity.enums.CategoryName;
import com.bookStore.model.service.ProductServiceModel;
import com.bookStore.model.view.ProductViewModel;
import com.bookStore.repository.ProductRepository;
import com.bookStore.service.CategoryService;
import com.bookStore.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {
        Product product = this.modelMapper.map(productServiceModel, Product.class);
        product.setCategory(categoryService
                .findByName(product.getCategory().getName()));
        System.out.println("Saving product: " + productServiceModel);
        this.productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalSum() {
        return this.productRepository.findTotalProductsSum();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategoryName(CategoryName categoryName) {
        return productRepository.findAllByCategory_Name(categoryName)
                .stream().map(p -> modelMapper.map(p, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyById(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
