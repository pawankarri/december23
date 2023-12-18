package com.nov.repo;

import com.nov.entites.Product;
import com.nov.entites.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailsRepo extends JpaRepository<ProductDetails,Long> {
    ProductDetails findByProductId(long id1);

    List<ProductDetails> findAllByProductId(long productId);
}
