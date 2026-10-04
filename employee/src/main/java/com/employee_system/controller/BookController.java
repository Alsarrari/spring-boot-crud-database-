package com.employee_system.controller;

import com.employee_system.model.Book;
import com.employee_system.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    @PostMapping("/add")
    public Book createBook(@RequestBody Book book){
     return bookService.addBook(book);
    }
    @GetMapping("/getAll")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id ){
        return bookService.getBookById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id ){
        bookService.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable Long id ,
                                     @RequestBody Book book){
        return bookService.updateBook(id, book);

    }
}
