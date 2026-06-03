package com.jupiracijunior.blog.services;

import com.jupiracijunior.blog.dto.request.ArticleRequestDTO;
import com.jupiracijunior.blog.model.Article;
import com.jupiracijunior.blog.model.Tags;
import com.jupiracijunior.blog.repository.ArticleRepository;
import com.jupiracijunior.blog.utils.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServices {

    @Autowired
    private ArticleRepository repository;


    public Article save(ArticleRequestDTO articleDTO) {

        if (!Valid.isNotNull(articleDTO))
            throw new NullPointerException("ArticleRequestDTO is null or contains empty item");

        Article entity = new Article();

        entity.setTitle(articleDTO.getTitle());
        entity.setContent(articleDTO.getContent());
        entity.setCategory(articleDTO.getCategory());

        List<Tags> tagsArticleDTO = new ArrayList<>();
        for (String description : articleDTO.getTags()) {
            tagsArticleDTO.add(Valid.converterStringToTags(description));
        }

        entity.setTag(tagsArticleDTO);
        entity.setCreateAt(LocalDateTime.now());
        entity.setUpdateAt(LocalDateTime.now());

        return repository.save(entity);
    }
}
