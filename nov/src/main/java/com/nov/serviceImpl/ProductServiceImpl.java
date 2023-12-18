package com.nov.serviceImpl;

import com.nov.dto.ProductDto;
import com.nov.entites.Product;
import com.nov.entites.ProductDetails;
import com.nov.entites.ProductQuestion;
import com.nov.repo.ProductDetailsRepo;
import com.nov.repo.ProductQuestionRepo;
import com.nov.repo.ProductRepo;
import com.nov.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductDetailsRepo detailsRepo;
    @Autowired
    private ProductQuestionRepo questionRepo;
    Map<String,Object> map=new HashMap<>();
    @Override
    public Map<String, Object> findAll() {
        List<Product> list= this.productRepo.findAll();
        map.put("result",list);
        map.put("status", HttpStatus.OK.value());
        return map;

    }




//    @Override
//    public ResponseEntity<Map<String, Object>> findByPid(long id) {
//        return null;
//    }



//    @Override
//    public Map<String, Object> findByPid(long id) {
//        List<Object> list=new ArrayList<>();
//        ProductDto dto=new ProductDto();
//        Product id1=this.productRepo.findById(id).orElse(null);
//        ProductDetails details=this.detailsRepo.findByProductId(id1);
//        ProductQuestion question=this.questionRepo.findByProductId(id1);
//        dto.setProductId(id1.getProductId());
//        dto.setProductName(id1.getProductName());
//        dto.setProductModel(details.getProductModel());
//        dto.setProductRam(details.getProductRam());
//        dto.setProductPrice(details.getProductPrice());
//        dto.setProductQuestions(question.getProductQuestions());
//        list.add(dto);
//        map.put("result",list);
//        map.put("status",HttpStatus.OK.value());
//        return  map;
//    }



}
