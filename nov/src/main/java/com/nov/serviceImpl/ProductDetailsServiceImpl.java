package com.nov.serviceImpl;

import com.nov.dto.ProductDto;
import com.nov.entites.Product;
import com.nov.entites.ProductDetails;
import com.nov.entites.ProductQuestion;
import com.nov.repo.ProductDetailsRepo;
import com.nov.repo.ProductQuestionRepo;
import com.nov.repo.ProductRepo;
import com.nov.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

    @Autowired
    private ProductRepo product;

    @Autowired
    private ProductDetailsRepo detailsRepo;

    @Autowired
    private ProductQuestionRepo questionRepo;

    Map<String,Object> map=new HashMap<>();
    @Override
    public Map<String,Object> getProductDetailsAndQuestionsByProductId(long productId) {
      List<ProductDto> dtos=new ArrayList<>();
      Product product1=this.product.findById(productId).orElseThrow();
        ProductDetails details=this.detailsRepo.findByProductId(productId);
        List<ProductQuestion> questions= this.questionRepo.findAllByProductId(productId);

        ProductDto dto=new ProductDto();
        dto.setProductId(details.getProductId());
        dto.setProductRam(details.getProductRam());
        dto.setProductModel(details.getProductModel());
        dto.setProductPrice(details.getProductPrice());
        dto.setProductName(product1.getProductName());
        List<String> questionDescriptions = questions.stream()
                .map(ProductQuestion::getProductQuestions)
                .collect(Collectors.toList());
        dto.setQuestions(questionDescriptions);
        dtos.add(dto);
        map.put("productDetails",dtos);
        map.put("status", HttpStatus.OK.value());

        return map;
    }
}
