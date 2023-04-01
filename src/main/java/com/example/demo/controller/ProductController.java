package com.example.demo.controller;

import com.example.demo.BaseResponse;
import com.example.demo.business.product.create.ICreateProduct;
import com.example.demo.business.product.create.dto.ProductRequest;
import com.example.demo.business.product.inquiry.IInquiryProduct;
import com.example.demo.business.product.update.IUpdateProduct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = {"api/v1/products"})
public class ProductController {

    private final ICreateProduct iCreateProduct;
    private final IInquiryProduct iInquiryProduct;
    private final IUpdateProduct iUpdateProduct;

    public ProductController(ICreateProduct iCreateProduct, IInquiryProduct iInquiryProduct, IUpdateProduct iUpdateProduct) {
        this.iCreateProduct = iCreateProduct;
        this.iInquiryProduct = iInquiryProduct;
        this.iUpdateProduct = iUpdateProduct;
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getProducts() {
        return ResponseEntity.ok(iInquiryProduct.getProducts());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> createProduct(@Valid @RequestBody ProductRequest product) {
        return ResponseEntity.ok(iCreateProduct.createProduct(product));
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<BaseResponse> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(iUpdateProduct.deleteProduct(id));
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<BaseResponse> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequest product) {
        return ResponseEntity.ok(iUpdateProduct.updateProduct(id, product));
    }
}
