package com.example.demo.business.product.create.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @NotBlank
    String name;
    @Min(value = 1)
    Integer quantity;
    @Min(value = 100)
    Integer price;
}
