package com.example.springbootcache.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author "Tojaliyev Asliddin"
 * @since 14/08/22 11:38 (Sunday)
 * Spring-boot-cache/IntelliJ IDEA
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateDto {
    private String name;

    private String author;
    private String genre;
}
