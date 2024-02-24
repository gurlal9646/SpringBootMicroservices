package org.example.borrowservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient("book-service")
public interface IBookClient {

    @GetMapping("/books/list")
    public List<Book> getBooks();
    @PutMapping("/books/updateAvailability/{id}")
    public ResponseEntity<String> updateBookStatus(@PathVariable Long id, @RequestParam("status") String status);
}