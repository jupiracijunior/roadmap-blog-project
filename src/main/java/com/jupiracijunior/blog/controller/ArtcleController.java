package com.jupiracijunior.blog.controller;

import com.jupiracijunior.blog.dto.request.ArticleRequestDTO;
import com.jupiracijunior.blog.model.Article;
import com.jupiracijunior.blog.services.ArticleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ArtcleController {

    @Autowired
    private ArticleServices service;

    @GetMapping("/posts/{id}")
    public Article getPost(@PathVariable Integer id) {
        return service.getPost(id);
    }

    @PostMapping("/posts")
    public Article posts(@RequestBody ArticleRequestDTO articleDTO) {
        return service.save(articleDTO);
    }

    @PutMapping("/posts/{id}")
    public Article posts(@RequestBody ArticleRequestDTO articleDTO, @PathVariable Integer id) {
        return service.update(articleDTO, id);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
