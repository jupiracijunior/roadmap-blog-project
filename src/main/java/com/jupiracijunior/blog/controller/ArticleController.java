package com.jupiracijunior.blog.controller;

import com.jupiracijunior.blog.dto.request.ArticleRequestDTO;
import com.jupiracijunior.blog.model.Article;
import com.jupiracijunior.blog.services.ArticleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ArticleController {

    @Autowired
    private ArticleServices service;

    @GetMapping("/posts")
    public List<Article> getAllPosts(@RequestParam("term") String term) {
        if (!term.isEmpty() && term != null) {
            return service.searchByTerm(term);
        }

        return service.getAllArticles();
    }

    @GetMapping("/posts/{id}")
    public Article getPost(@PathVariable Integer id) {
        return service.getPost(id);
    }

    @PostMapping("/posts")
    public Article save(@RequestBody ArticleRequestDTO articleDTO) {
        return service.save(articleDTO);
    }

    @PutMapping("/posts/{id}")
    public Article update(@RequestBody ArticleRequestDTO articleDTO, @PathVariable Integer id) {
        return service.update(articleDTO, id);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Exception handler area

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> handleException(EmptyResultDataAccessException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatusCode.valueOf(404)); // 404 - Not found
    }
}
