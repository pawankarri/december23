package com.nov.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "productquestion")
public class ProductQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productQuestionId;
    private String productQuestions;
    private long productId;
}
