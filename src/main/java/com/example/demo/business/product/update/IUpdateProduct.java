package com.example.demo.business.product.update;

import com.example.demo.BaseResponse;
import com.example.demo.business.product.create.dto.ProductRequest;

public interface IUpdateProduct {
    BaseResponse deleteProduct(Long id);

    BaseResponse updateProduct(Long id, ProductRequest product);
}
