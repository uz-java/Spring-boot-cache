package com.example.springbootcache;

import com.example.springbootcache.domains.Book;
import com.example.springbootcache.repository.BookRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
@EnableCaching
public class SpringBootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(BookRepository bookRepository) {
        return (args) -> {
            com.github.javafaker.Book book = new Faker().book();
            List<Book> books = IntStream.rangeClosed(1, 100).mapToObj(i -> Book.builder()
                    .name(book.title())
                    .author(book.author())
                    .createdAt(LocalDateTime.now(Clock.systemDefaultZone()))
                    .genre(book.genre()).build()).toList();
            bookRepository.saveAll(books);
        };
    }

}
