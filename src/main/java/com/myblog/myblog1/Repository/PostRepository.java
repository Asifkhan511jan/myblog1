package com.myblog.myblog1.Repository;

import com.myblog.myblog1.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

}
