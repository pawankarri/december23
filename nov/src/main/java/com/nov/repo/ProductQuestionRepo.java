package com.nov.repo;

import com.nov.entites.Product;
import com.nov.entites.ProductQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductQuestionRepo extends JpaRepository<ProductQuestion,Long> {
    ProductQuestion findByProductId(long id1);

    List<ProductQuestion> findAllByProductId(long productId);
}
