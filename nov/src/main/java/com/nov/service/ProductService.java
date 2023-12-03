package com.nov.service;

import com.nov.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface ProductService {


    Map<String,Object> findAll();

//    ResponseEntity<Map<String, Object>> findByPid();

//    ResponseEntity<Map<String, Object>> findByPid(long id);



}
