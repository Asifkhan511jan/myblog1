package com.myblog.myblog1.Service.Impl;

import com.myblog.myblog1.Entity.Post;
import com.myblog.myblog1.Repository.PostRepository;
import com.myblog.myblog1.Service.PostService;
import com.myblog.myblog1.payload.PostDto;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post=new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post savedPost = postRepository.save(post);

        PostDto dto=new PostDto();
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent());

        return dto;
    }
}
