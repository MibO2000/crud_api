package com.example.demo.business.product.update;

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
public class IUpdateProductImp extends BaseBusiness implements IUpdateProduct {
    @Autowired
    ProductService productService;

    @Override
    public BaseResponse deleteProduct(Long id) {
        Product product = findById(id);
        productService.deleteById(id);
        return generateDefaultResponse("Deleted the product: "+product.getName());
    }

    @Override
    public BaseResponse updateProduct(Long id, ProductRequest productRequest) {
        Product product = findById(id);
        // check product name for duplicate
        if (checkDuplicate(productRequest.getName(), product.getName())) {
            throw new IllegalStateException("Product already exists!");
        }
        //change the data
        product.setName(productRequest.getName());
        product.setQuantity(productRequest.getQuantity());
        product.setPrice(productRequest.getPrice());
        // save in database
        product = productService.save(product);
        //return
        return generateDefaultResponse(product);
    }
}
