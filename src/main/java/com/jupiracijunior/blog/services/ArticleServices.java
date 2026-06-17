package com.jupiracijunior.blog.services;

import com.jupiracijunior.blog.dto.request.ArticleRequestDTO;
import com.jupiracijunior.blog.model.Article;
import com.jupiracijunior.blog.model.Tags;
import com.jupiracijunior.blog.repository.ArticleRepository;
import com.jupiracijunior.blog.repository.TagRepository;
import com.jupiracijunior.blog.utils.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.FileSystemNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServices {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private TagRepository tagRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getPost(Integer id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new FileSystemNotFoundException("Tag not found"));
    }

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

    public void delete(Integer id) {
        if (!articleRepository.existsById(id)) {
            throw new EmptyResultDataAccessException("Article with id " + id + " not found", 1);
        }

        articleRepository.deleteById(id);
    }

    private List<Tags> mapTags(ArticleRequestDTO articleDTO) {
        List<Tags> tagsArticleEntity = new ArrayList<>();
        for (String description : articleDTO.getTags()) {
            tagsArticleEntity.add(tagRepository.findByDescription(description)
                    .orElseThrow(() -> new FileSystemNotFoundException("Tag not found")));
        }
        return tagsArticleEntity;
    }

    public List<Article> searchByTerm(String term) {
        return articleRepository.findByTagDescription(term);
    }
}
