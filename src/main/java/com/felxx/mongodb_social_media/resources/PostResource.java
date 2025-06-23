package com.felxx.mongodb_social_media.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felxx.mongodb_social_media.domain.Post;
import com.felxx.mongodb_social_media.resources.util.URL;
import com.felxx.mongodb_social_media.services.PostService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService postService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> posts = postService.findByTitle(text);
        return ResponseEntity.ok().body(posts);
    }
}
