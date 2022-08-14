package com.example.springbootcache.repository;

import com.example.springbootcache.domains.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Tojaliyev Asliddin"
 * @since 14/08/22 11:40 (Sunday)
 * Spring-boot-cache/IntelliJ IDEA
 */
public interface BookRepository extends JpaRepository<Book,Long> {
}
