package com.nov.service;

import com.nov.dto.ProductDto;

import java.util.Map;

public interface ProductDetailsService {
    Map<String,Object> getProductDetailsAndQuestionsByProductId(long productId);
}
