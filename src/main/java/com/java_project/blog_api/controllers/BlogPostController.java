package com.java_project.blog_api.controllers;

import com.java_project.blog_api.entity.BlogPost;
import com.java_project.blog_api.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    List<BlogPost> list(){
        return blogPostService.list();
    }
    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getById(@PathVariable Long id){
        Optional<BlogPost> blogPost = blogPostService.getById(id);
        return blogPost
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<List<BlogPost>> create(@RequestBody BlogPost blogPost){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(blogPostService.create(blogPost));
   }

    @PutMapping("{id}")
    List<BlogPost> update(@PathVariable Long id,@RequestBody BlogPost blogPost){
        return blogPostService.update(id, blogPost);
   }


    @DeleteMapping("{id}")
    List<BlogPost> delete(@PathVariable Long id){
        return blogPostService.delete(id);
   }

}
