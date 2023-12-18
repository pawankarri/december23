package com.nov.controller;

import com.nov.dto.ProductDto;
import com.nov.service.ProductDetailsService;
import com.nov.service.ProductService;
import com.nov.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;
@Autowired
private ProductDetailsService detailsService;
    @GetMapping("/find-by-all")
    public ResponseEntity<Map<String,Object>> findAll()
    {
        Map<String, Object> result = this.productService.findAll();
        return ResponseEntity.ok().body(result);
    }
@GetMapping("/find-id/{productId}")
public ResponseEntity<Map<String,Object>> getProductDetailsAndQuestions(@PathVariable long productId) {
    Map<String,Object> result = detailsService.getProductDetailsAndQuestionsByProductId(productId);
    return ResponseEntity.ok().body(result);
}


@PostMapping("/insert")
    public  ResponseEntity<Map<String,Object>> insert(@RequestBody ProductDto dto)
{
     Map<String,Object> res=this.detailsService.insert(dto);
    return ResponseEntity.ok().body(res);
}


}
