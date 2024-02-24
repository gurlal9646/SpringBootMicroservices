package org.example.bookservice;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("books")
public class BookController {

    @Autowired
    private final IBookRepository bookRepository;

    // Add a new book
    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok("Book added successfully");
    }

    // Update an existing book
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        if (!bookRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        updatedBook.setId(id);
        bookRepository.save(updatedBook);
        return ResponseEntity.ok("Book updated successfully");
    }

    // Delete a book
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        if (!bookRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        bookRepository.deleteById(id);
        return ResponseEntity.ok("Book deleted successfully");
    }

    // Get all books
    @GetMapping("/list")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return ResponseEntity.ok(books);
    }

    // To update the book status to available or borrowed
    @PutMapping("/updateAvailability/{id}")
    public ResponseEntity<String> updateBookAvailability(@PathVariable Long id, @RequestParam String status) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setAvailability(status);
            bookRepository.save(book);
            return ResponseEntity.ok("Book availability updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
