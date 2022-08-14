package com.example.springbootcache.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Tojaliyev Asliddin"
 * @since 14/08/22 11:39 (Sunday)
 * Spring-boot-cache/IntelliJ IDEA
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookUpdateDto {
    private String id;
    private String name;
    private String author;
    private String genre;
}
