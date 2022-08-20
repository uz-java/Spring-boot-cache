package com.example.springbootcache.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author "Tojaliyev Asliddin"
 * @since 14/08/22 11:37 (Sunday)
 * Spring-boot-cache/IntelliJ IDEA
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Data
@Entity
public class Book implements Serializable {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    private String name;
    private String author;
    private String genre;
    private LocalDateTime createdAt;
}
