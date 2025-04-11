package ru.bookman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.bookman.model.Book;
import ru.bookman.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Page<Book> getBooks(String title, Integer year, String brand, PageRequest pageRequest) {
        if (title != null || year != null || brand != null) {
            return bookRepository.findByTitleContainingAndYearAndBrand(title, year, brand, pageRequest);
        }
        return bookRepository.findAll(pageRequest);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Long id, Book updatedBook) {
        Book existingBook = getBookById(id);
        existingBook.setVendorCode(updatedBook.getVendorCode());
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setYear(updatedBook.getYear());
        existingBook.setBrand(updatedBook.getBrand());
        existingBook.setStock(updatedBook.getStock());
        existingBook.setPrice(updatedBook.getPrice());
        bookRepository.save(existingBook);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}