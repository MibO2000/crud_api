package com.example.demo.business.product.create;

import com.example.demo.BaseResponse;
import com.example.demo.business.product.create.dto.ProductRequest;

public interface ICreateProduct {
    BaseResponse createProduct(ProductRequest product);
}
