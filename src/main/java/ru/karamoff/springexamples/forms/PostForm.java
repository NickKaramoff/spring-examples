package ru.karamoff.springexamples.forms;

import lombok.Data;

@Data
public class PostForm {
    private String topic;
    private String text;
    private Long parentPostId;
}
