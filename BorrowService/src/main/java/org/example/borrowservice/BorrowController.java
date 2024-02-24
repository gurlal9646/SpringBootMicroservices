package org.example.borrowservice;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("borrow")
public class BorrowController {
    private final IBookClient bookClient;
    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookClient.getBooks();
    }

    @PutMapping("/updateAvailability/{id}")
    public ResponseEntity<String> updateBookAvailability(@PathVariable Long id, @RequestParam String status) {
        System.out.println(id+" "+status);
        return bookClient.updateBookStatus(id,status);
    }

}
