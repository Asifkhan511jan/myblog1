package com.myblog.myblog1.Controller;

import com.myblog.myblog1.Service.CommentService;
import com.myblog.myblog1.payload.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/comments")
public class CommentController {


    @Autowired
    private CommentService commentService;
    private CommentService postService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    //http://localhost:8080/api/comments?postId=1
    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @RequestParam long id) {
        CommentDto dto = commentService.createComment(commentDto, id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long id){
        commentService.deleteComment(id);
        return  ResponseEntity.ok("Hhs");
    }

    @PutMapping("/{id}/post/{postId}")
 public ResponseEntity<CommentDto> updateComment(
         @PathVariable long id,@RequestBody CommentDto commentDto,@PathVariable long postId){
        CommentDto dto = commentService.updateComment(id, commentDto,postId);
        return ResponseEntity.ok(dto);

    }
    // delete post rest api
}
