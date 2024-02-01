package com.myblog.myblog1.Controller;

import com.myblog.myblog1.Service.PostService;
import com.myblog.myblog1.payload.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
@PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return  new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

}
