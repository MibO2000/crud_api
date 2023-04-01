package com.example.demo.business.product;

import com.example.demo.database.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findById(Long id);

    List<Product> getAll();

    Product save(Product product);

    void deleteById(Long id);
}
