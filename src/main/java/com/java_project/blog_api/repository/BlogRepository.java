package com.java_project.blog_api.repository;

import com.java_project.blog_api.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogRepository extends JpaRepository<BlogPost, Long> {
    Optional<BlogPost> findById(Long id);
}
