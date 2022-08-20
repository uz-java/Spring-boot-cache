package com.example.springbootcache.events;

import lombok.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 20/08/22 11:49 (Saturday)
 * Spring-boot-cache/IntelliJ IDEA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookCreateEvent {
    private String id;
    private String title;
    private String author;
}
