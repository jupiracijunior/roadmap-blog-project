package com.jupiracijunior.blog.repository;

import com.jupiracijunior.blog.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tags, Integer> {

    Optional<Tags> findByDescription(String description);


}
