package com.example.springbootcache.service;

import com.example.springbootcache.domains.Book;
import com.example.springbootcache.dto.BookCreateDto;
import com.example.springbootcache.dto.BookUpdateDto;
import com.example.springbootcache.events.BookCreateEvent;
import com.example.springbootcache.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author "Tojaliyev Asliddin"
 * @since 14/08/22 11:41 (Sunday)
 * Spring-boot-cache/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final ApplicationEventPublisher publisher;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @SneakyThrows
    @Cacheable(cacheNames = "book", key = "#id")
    public Book getOne(String id) {
        //TODO: 14/08/22 some logic here that takes around  3 4 seconds
        TimeUnit.SECONDS.sleep(2);
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found by id %s".formatted(id)));
    }

    public void create(BookCreateDto dto) {
        Optional<Book> name = bookRepository.findByName(dto.getName());
        if (name.isPresent()) {
            throw new RuntimeException("Book name already taken %s".formatted(dto.getName()));
        }

        Book book = Book.builder()
                .name(dto.getName())
                .author(dto.getAuthor())
                .genre(dto.getGenre())
                .createdAt(LocalDateTime.now(Clock.systemDefaultZone()))
                .build();
        Book save = bookRepository.save(book);
        publisher.publishEvent(new BookCreateEvent(
                save.getId(),
                save.getName(),
                save.getAuthor()));
    }

    public Book update(BookUpdateDto dto) {
        Book book = getOne(dto.getId());

        if (dto.getName() != null) {
            book.setName(dto.getName());
        }
        if (dto.getAuthor() != null) {
            book.setAuthor(dto.getAuthor());
        }
        if (dto.getGenre() != null) {
            book.setGenre(dto.getGenre());
        }
        return bookRepository.save(book);
    }

    @CacheEvict(cacheNames = "book", key = "#id")
    public void delete(String id) {
        bookRepository.deleteById(id);
    }
}
