package com.example.springbootcache.controller;

import com.example.springbootcache.domains.Book;
import com.example.springbootcache.dto.BookCreateDto;
import com.example.springbootcache.dto.BookUpdateDto;
import com.example.springbootcache.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 14/08/22 11:39 (Sunday)
 * Spring-boot-cache/IntelliJ IDEA
 */
@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> books(){
        return bookService.getAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody BookCreateDto dto){
        bookService.create(dto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getOne(@PathVariable String id){
     return bookService.getOne(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  Book update(@RequestBody BookUpdateDto dto){
        return bookService.update(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){
        bookService.delete(id);
    }
}
