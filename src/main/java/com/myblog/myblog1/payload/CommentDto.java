package com.myblog.myblog1.payload;


import javax.persistence.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private long id;

    private String text;

    private String Email;
}
