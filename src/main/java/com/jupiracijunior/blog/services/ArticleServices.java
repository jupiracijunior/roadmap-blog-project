package com.jupiracijunior.blog.services;

import com.jupiracijunior.blog.dto.request.ArticleRequestDTO;
import com.jupiracijunior.blog.model.Article;
import com.jupiracijunior.blog.model.Tags;
import com.jupiracijunior.blog.repository.ArticleRepository;
import com.jupiracijunior.blog.repository.TagRepository;
import com.jupiracijunior.blog.utils.Valid;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServices {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private TagRepository tagRepository;

    public Article save(ArticleRequestDTO articleDTO) {

        if (!Valid.isNotNull(articleDTO))
            throw new NullPointerException("ArticleRequestDTO is null or contains empty item");

        Article entity = new Article();

        entity.setTitle(articleDTO.getTitle());
        entity.setContent(articleDTO.getContent());
        entity.setCategory(articleDTO.getCategory());

        List<Tags> tagsArticleEntity = mapTags(articleDTO);

        entity.setTag(tagsArticleEntity);
        entity.setCreateAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());

        return articleRepository.save(entity);
    }

    public Article update(ArticleRequestDTO articleDTO, Integer id) {
        Article entity = articleRepository.findById(id)
                .orElseThrow(() -> new FileSystemNotFoundException("Tag not found"));

        entity.setTitle(articleDTO.getTitle());
        entity.setContent(articleDTO.getContent());
        entity.setCategory(articleDTO.getCategory());

        List<Tags> tagsArticleEntity = mapTags(articleDTO);

        entity.setTag(tagsArticleEntity);
        entity.setUpdatedAt(LocalDateTime.now());

        return articleRepository.save(entity);
    }

    private List<Tags> mapTags(ArticleRequestDTO articleDTO) {
        List<Tags> tagsArticleEntity = new ArrayList<>();
        for (String description : articleDTO.getTags()) {
            tagsArticleEntity.add(tagRepository.findByDescription(description)
                    .orElseThrow(() -> new FileSystemNotFoundException("Tag not found")));
        }
        return tagsArticleEntity;
    }
}
