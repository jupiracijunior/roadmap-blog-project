package com.jupiracijunior.blog.utils;

import com.jupiracijunior.blog.dto.request.ArticleRequestDTO;
import com.jupiracijunior.blog.model.Tags;

public class Valid {

    public static boolean isNotNull(ArticleRequestDTO articleDTO) {
        boolean validate = articleDTO != null &&
                articleDTO.getTitle() != null &&
                articleDTO.getContent() != null &&
                articleDTO.getCategory() != null &&
                articleDTO.getTags() != null;

        return validate;
    }

    public static Tags converterStringToTags(String description) {
        Tags tags = new Tags();

        tags.setDescription(description);

        return tags;
    }
}
