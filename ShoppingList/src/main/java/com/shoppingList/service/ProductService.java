package com.bookStore.service;

import com.bookStore.model.entity.enums.CategoryName;
import com.bookStore.model.service.ProductServiceModel;
import com.bookStore.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);
    BigDecimal getTotalSum();
    List<ProductViewModel>findAllProductsByCategoryName(CategoryName categoryName);

    void buyById(UUID id);

    void buyAll();
}
