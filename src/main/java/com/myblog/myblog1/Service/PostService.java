
package com.myblog.myblog1.Service;

import com.myblog.myblog1.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostDto getPostId(long id);

    List<PostDto> getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
}
