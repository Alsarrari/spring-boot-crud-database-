package com.employee_system.repository;

import com.employee_system.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
Optional<Book> findByName(String name);
Optional<Book> findByCategoryAndPrice(String category , double price);
List<Book> findByNameContaining(String name);
List<Book> findByNameEndingWith(String name);
List<Book> findByNameIgnoreCase(String name);
List<Book> findByPriceGreaterThan(double price);
List<Book> findByPriceLessThan(double price);
List<Book> findByPriceGreaterThanEqual(double price);
List<Book> findByPriceLessThanEqual(double price);
List<Book> findByCategoryAndPriceGreaterThan(String category , double price);
Optional<Book> findByEmail(String email);
}
