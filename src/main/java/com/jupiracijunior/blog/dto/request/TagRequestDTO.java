package com.jupiracijunior.blog.dto.request;

import java.util.List;
import java.util.Objects;

public class TagRequestDTO {

    private List<String> description;

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TagRequestDTO that = (TagRequestDTO) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(description);
    }
}
