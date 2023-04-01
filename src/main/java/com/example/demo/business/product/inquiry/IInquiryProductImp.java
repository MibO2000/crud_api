package com.example.demo.business.product.inquiry;

import com.example.demo.BaseResponse;
import com.example.demo.business.BaseBusiness;
import com.example.demo.business.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IInquiryProductImp extends BaseBusiness implements IInquiryProduct {
    @Autowired
    ProductService productService;

    @Override
    public BaseResponse getProducts() {
        return generateDefaultResponse(productService.getAll());
    }
}
