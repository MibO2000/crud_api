package com.example.demo.business;

import com.example.demo.BaseResponse;
import com.example.demo.business.product.create.dto.ProductRequest;
import com.example.demo.database.entity.Product;
import com.example.demo.database.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class BaseBusiness {

    @Autowired
    ProductRepository productRepository;

    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) throw new IllegalStateException("Product does not exist!");
        return product.get();
    }

    public boolean checkDuplicate(String name, String originalName) {
        if (name.equals(originalName)) return false;
        Optional<Product> product = productRepository.findProductByName(name);
        return product.isPresent();
    }

    public Object changeRequest(Object object) {
        ProductRequest request = (ProductRequest) object;
        return new Product(request.getName(), request.getQuantity(), request.getPrice());
    }


    public BaseResponse generateDefaultResponse(Object result) {
        return new BaseResponse("00000", "SUCCESS", result);
    }
}
