package com.employee_system.service;

import com.employee_system.model.Book;
import com.employee_system.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
    public class BookService {
    private final BookRepository bookRepository;

    public Book addBook(Book book){
        return bookRepository.save(book);
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Optional<Book> getBookById(Long id){
      return    bookRepository.findById(id);
    }
    public void deleteById(Long id ){
         bookRepository.deleteById(id);
    }
    public Book updateBook( Long id ,  Book book){
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepository.findById(id);
        existingBook.setName(book.getName());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setCategory(book.getCategory());
        existingBook.setPrice(book.getPrice());
       return bookRepository.save(existingBook);

    }

}
