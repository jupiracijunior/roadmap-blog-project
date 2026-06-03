package com.jupiracijunior.blog.dto.request;

import com.jupiracijunior.blog.model.Tags;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.List;
import java.util.Objects;

public class ArticleRequestDTO {

    private String title;
    private String content;
    private String category;
    private List<String> tags;

    public ArticleRequestDTO() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ArticleRequestDTO that = (ArticleRequestDTO) o;
        return Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(category, that.category) && Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, category, tags);
    }
}
