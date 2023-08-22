package com.crud.template.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "example")
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "content")
    private String content;

    public Example() {
    }

    public Example(String content) {
        this.content = content;
    }

    public Example(short id, String content) {
        this.id = id;
        this.content = content;
    }
}
