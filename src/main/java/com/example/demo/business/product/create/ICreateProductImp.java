package com.example.demo.business.product.create;

import com.example.demo.BaseResponse;
import com.example.demo.business.BaseBusiness;
import com.example.demo.business.product.ProductService;
import com.example.demo.business.product.create.dto.ProductRequest;
import com.example.demo.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ICreateProductImp extends BaseBusiness implements ICreateProduct {
    @Autowired
    ProductService productService;


    @Override
    public BaseResponse createProduct(ProductRequest productRequest) {
        // check product name for duplicate
        if (checkDuplicate(productRequest.getName(),null)) {
            throw new IllegalStateException("Product already exists!");
        }
        //change the data
        Product product = (Product) changeRequest(productRequest);
        // save in database
        product = productService.save(product);
        //return
        return generateDefaultResponse(product);
    }
}
