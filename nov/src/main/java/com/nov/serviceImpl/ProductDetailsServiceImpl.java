package com.nov.serviceImpl;

import com.nov.dto.ProductDto;
import com.nov.entites.Product;
import com.nov.entites.ProductDetails;
import com.nov.entites.ProductQuestion;
import com.nov.exception.IdNotFoundException;
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

    @Override
    public Map<String, Object> insert(ProductDto dto) {
        List<ProductQuestion> list=new ArrayList<>();
        ProductDetails details=new ProductDetails();
        Product product1 = this.product.findById(dto.getProductId()).orElseThrow(() -> new IdNotFoundException("id doesn't exists"));
        if(product1!=null) {
            details.setProductId(product1.getProductId());
            details.setProductModel(dto.getProductModel());
            details.setProductRam(dto.getProductRam());
            details.setProductPrice(dto.getProductPrice());
            detailsRepo.save(details);

        }
        else {
            throw new RuntimeException("data doesn't save");
        }

        for (String s : dto.getQuestions()) {
            ProductQuestion question = new ProductQuestion();
            question.setProductId(product1.getProductId());
            question.setProductQuestions(s);
            list.add(question);

        }
        questionRepo.saveAll(list);
        map.put("result",HttpStatus.CREATED.value());
        map.put("productDetails",details);
        map.put("productQuestions",list);
        return map;


    }
}
