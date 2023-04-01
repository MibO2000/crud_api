package com.example.demo.business.product;

import com.example.demo.database.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product save(Product product);

    void deleteById(Long id);
}
