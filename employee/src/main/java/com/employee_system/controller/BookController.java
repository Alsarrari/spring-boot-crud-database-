package com.employee_system.controller;

import com.employee_system.api.ApiResponse;
import com.employee_system.model.Book;
import com.employee_system.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createBook(@Valid @RequestBody Book book){
        Book addBook=bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse("Book created successfully",addBook));

    }
    @GetMapping("/getAll")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id ){
        return bookService.getBookById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id ){
        bookService.deleteById(id);
       return ResponseEntity.status(HttpStatus.OK)
               .body(new ApiResponse("Book deleted successfully",null));
    }
    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable Long id ,
                                     @RequestBody Book book){
        return bookService.updateBook(id, book);
    }
    @GetMapping("/name")
    public Optional<Book> getBookByName(@RequestParam String name){
        return bookService.getBookByName(name);
    }
    @GetMapping("/search")
    public Optional<Book> findByCategoryAndPrice(@RequestParam String category,
                                                 @RequestParam double price){
        return this.bookService.findByCategoryAndPrice(category, price);
    }
    @GetMapping("/containing")
    public List<Book> findByNameContaining(@RequestParam String name){
        return this.bookService.findByNameContaining(name);
    }
    @GetMapping("/endingWith")
    public List<Book> findByNameEndingWith(@RequestParam String name){
        return this.bookService.findByNameEndingWith(name);
    }
    @GetMapping("/ignorecase")
    public List<Book> findByNameIgnoreCase(@RequestParam String name){
        return bookService.findByNameIgnoreCase(name);
    }

    @GetMapping("/greaterthan")
    public List<Book> findByPriceGreaterThan(@RequestParam double price){
        return bookService.findByPriceGreaterThan(price);
    }

    @GetMapping("/lessthan")
    public List<Book> findByPriceLessThan(@RequestParam double price){
        return bookService.findByPriceLessThan(price);
    }

    @GetMapping("/greaterthanEqual")
    public List<Book> findByPriceGreaterThanEqual(@RequestParam double price){
        return bookService.findByPriceGreaterThanEqual(price);
    }

    @GetMapping("/lessthanEqual")
    public List<Book> findByPriceLessThanEqual(@RequestParam double price){
        return bookService.findByPriceLessThanEqual(price);
    }
    @GetMapping("/categoryAndPrice")
    public List<Book> findByCategoryAndPriceGreaterThan(@RequestParam String category ,
                                                             @RequestParam double price){
        return bookService.findByCategoryAndPriceGreaterThan(category, price);
    }
    @PutMapping("/updateTwoBooks")
    public void updateTwoBooks(@RequestParam Long id1,
                               @RequestParam Long id2){
        bookService.updateTwoBooks(id1, id2);
    }



}
