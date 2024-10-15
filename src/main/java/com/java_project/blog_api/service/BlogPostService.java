package com.java_project.blog_api.service;

import com.java_project.blog_api.entity.BlogPost;
import com.java_project.blog_api.exception.BadRequestException;
import com.java_project.blog_api.repository.BlogRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {
    private BlogRepository blogRepository;


    public BlogPostService(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    public List<BlogPost> list(){
        Sort sort = Sort.by(Sort.Direction.DESC, "postDate");
        return blogRepository.findAll(sort);
    }

    public Optional<BlogPost> getById(Long id){
        return blogRepository.findById(id);
    }

    public List<BlogPost> create(BlogPost blogPost){
        blogRepository.save(blogPost);
        return list();
    }

    public List<BlogPost> update(Long id, BlogPost blogPost){
        blogRepository.findById(id).ifPresentOrElse((existingBlogPost) -> {
            blogPost.setId(id);
            blogRepository.save(blogPost);
        }, () -> {
            throw new BadRequestException("Esse post não existe!");
        });
        return list();
    }

    public List<BlogPost> delete(Long id){
        blogRepository.findById(id).ifPresentOrElse((existingBlogPost) -> {
            blogRepository.delete(existingBlogPost);
        }, () -> {
            throw new BadRequestException("Esse post não existe! ");
                });
        return list();
    }
}
