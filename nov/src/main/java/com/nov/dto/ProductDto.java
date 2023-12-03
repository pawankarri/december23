package com.nov.dto;

import com.nov.entites.ProductQuestion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private long productId;
    private String productName;
    private String productModel;
    private String productRam;
    private double productPrice;
    private List<String> questions;

}
