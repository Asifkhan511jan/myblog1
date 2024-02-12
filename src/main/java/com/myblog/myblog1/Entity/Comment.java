package com.myblog.myblog1.Entity;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Table(name ="comments")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class Comment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String text;

        private String email;

        @ManyToOne
        @JoinColumn(name = "post_id")
        private Post post;

        // Constructors, getters, and setters


}
