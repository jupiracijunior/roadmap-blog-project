package com.jupiracijunior.blog.repository;

import com.jupiracijunior.blog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
