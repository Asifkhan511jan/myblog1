package com.myblog.myblog1.Service;

import com.myblog.myblog1.payload.CommentDto;

public interface CommentService {

 public CommentDto  createComment(CommentDto commentDto,long id);

 public void deleteComment(long id);

   public CommentDto updateComment(long id, CommentDto commentDto, long postId);

    void deletePostById(long id);
}
