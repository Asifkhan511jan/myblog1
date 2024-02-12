package com.myblog.myblog1.Controller;

import com.myblog.myblog1.Service.PostService;
import com.myblog.myblog1.payload.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {

        this.postService = postService;
    }
    @PreAuthorize("hasRole('ADMIN')")
     @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return  new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/post/2
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long id){
        PostDto dto = postService.getPostId(id);
        return  new ResponseEntity<>(dto, HttpStatus.OK);
    }


   // http://localhost:8080/api/post?pageNo=0&pageSize=3&sortBy=title&sortDir=desc
    @GetMapping
      public List<PostDto> getAllPost(
              @RequestParam(name="pageNo", required = false, defaultValue = "0")int pageNo,
              @RequestParam(name="pageSize", required = false, defaultValue = "3")int pageSize,
              @RequestParam(name="sortBy", required = false, defaultValue = "id")String sortBy,
              @RequestParam(name="sortDir", required = false, defaultValue = "id")String sortDir
    ){

        List<PostDto> post = postService.getAllPost(pageNo, pageSize, sortBy, sortDir);
        return post;
      }

}
