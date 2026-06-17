package com.jupiracijunior.blog.repository;

import com.jupiracijunior.blog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    List<Article> findByTagDescription(String description);
}
