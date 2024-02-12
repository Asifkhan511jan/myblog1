package com.myblog.myblog1.Service.Impl;

import com.myblog.myblog1.Entity.Comment;
import com.myblog.myblog1.Entity.Post;
import com.myblog.myblog1.Execption.ResourceNotFoundException;
import com.myblog.myblog1.Repository.CommentRepository;
import com.myblog.myblog1.Repository.PostRepository;
import com.myblog.myblog1.Service.CommentService;
import com.myblog.myblog1.payload.CommentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CommentDto createComment(CommentDto commentDto, long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post not found with id:" + id)
        );

        Comment comment=new Comment();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);

        Comment savedComment = commentRepository.save(comment);

        CommentDto dto= new CommentDto();
        dto.setId(savedComment.getId());
        dto.setEmail(savedComment.getEmail());

        return dto;
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(long id, CommentDto commentDto, long Id) {
        Post post=postRepository.findById(Id).orElseThrow(
                () -> new ResourceNotFoundException("Post not found for id:" + Id)
        );
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comment not found for id:" + id)
        );

        Comment c = mapToEntity(commentDto);
        c.setId(comment.getId());
        c.setPost(post);
        Comment savedComment = commentRepository.save(c);

        return mapToDto(savedComment);
    }

    @Override
    public void deletePostById(long id) {

    }

    CommentDto mapToDto(Comment comment){
        CommentDto dto = modelMapper.map(comment, CommentDto.class);
         return dto;
    }

    Comment mapToEntity(CommentDto commentDto){
        Comment comment = modelMapper.map(commentDto, Comment.class);
        return comment;
    }

}
