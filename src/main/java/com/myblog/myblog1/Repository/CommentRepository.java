package com.myblog.myblog1.Repository;

import com.myblog.myblog1.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends  JpaRepository<Comment,Long>{
}
