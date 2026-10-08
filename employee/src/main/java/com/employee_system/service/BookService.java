package com.employee_system.service;

import com.employee_system.exception.BookAlreadyExistsException;
import com.employee_system.exception.BookNotFoundException;
import com.employee_system.model.Book;
import com.employee_system.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
    public class BookService {
    private final BookRepository bookRepository;

    public Book addBook(Book book){
       if (bookRepository.findByEmail(book.getEmail()).isPresent()){
           throw new BookAlreadyExistsException("Email already exists");
       }
        return bookRepository.save(book);
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book getBookById(Long id){

      return    bookRepository.findById(id).orElseThrow(()
              -> new BookNotFoundException("Book not found"));
    }
    public void deleteById(Long id ){
        if (!bookRepository.existsById(id)){
            throw new BookNotFoundException("Book nut found");
        }
         bookRepository.deleteById(id);
    }

    public Book updateBook( Long id ,  Book book){
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
        bookRepository.findById(id);
        existingBook.setName(book.getName());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setCategory(book.getCategory());
        existingBook.setPrice(book.getPrice());
       return bookRepository.save(existingBook);
    }
    public Optional<Book> getBookByName(String name){
    return bookRepository.findByName(name);
    }
    public Optional<Book> findByCategoryAndPrice(String category , double price){
        return bookRepository.findByCategoryAndPrice(category, price);
    }
    public List<Book> findByNameContaining(String name){
        return this.bookRepository.findByNameContaining(name);
    }
    public List<Book> findByNameEndingWith(String name){
        return this.bookRepository.findByNameEndingWith(name);
    }
    public List<Book> findByNameIgnoreCase(String name ){
        return bookRepository.findByNameIgnoreCase(name);
    }
    public List<Book> findByPriceGreaterThan(double price ){
        return bookRepository.findByPriceGreaterThan(price);
    }
    public List<Book> findByPriceLessThan(double price ){
        return bookRepository.findByPriceLessThan(price);
    }
    public List<Book> findByPriceGreaterThanEqual(double price ){
        return bookRepository.findByPriceGreaterThanEqual(price);
    }
    public List<Book> findByPriceLessThanEqual(double price ){
        return bookRepository.findByPriceLessThanEqual(price);
    }
    public List<Book> findByCategoryAndPriceGreaterThan(String category , double price){
        return bookRepository.findByCategoryAndPriceGreaterThan(category, price);
    }
    @Transactional
    public void updateTwoBooks(Long id1 , Long id2){
        Book b1 =bookRepository.findById(id1)
            .orElseThrow(() -> new RuntimeException("Book 1 not found"));
        Book b2 =bookRepository.findById(id2)
                .orElseThrow(() -> new RuntimeException("Book 2 not found"));
        b1.setPrice(1000);
        bookRepository.save(b1);
        b2.setPrice(2000);
        bookRepository.save(b2);
        throw new RuntimeException("Something went wrong!");
    }
//    public Book AddBook(Book  book)





}
