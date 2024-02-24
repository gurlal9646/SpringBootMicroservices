package org.example.bookservice;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DBSeeder implements CommandLineRunner {
    private final IBookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Book> movies = List.of(
                Book.builder().name("Forrest Gump").author("Winston Groom").rating(9.1).availability("available").build(),
                Book.builder().name("To Kill a Mockingbird").author("Harper Lee").rating(8.9).availability("available").build(),
                Book.builder().name("1984").author("George Orwell").rating(9.0).availability("borrowed").build(),
                Book.builder().name("The Great Gatsby").author("F. Scott Fitzgerald").rating(8.8).availability("available").build(),
                Book.builder().name("Pride and Prejudice").author("Jane Austen").rating(8.7).availability("borrowed").build(),
                Book.builder().name("The Catcher in the Rye").author("J.D. Salinger").rating(8.6).availability("available").build(),
                Book.builder().name("Moby-Dick").author("Herman Melville").rating(8.5).availability("available").build(),
                Book.builder().name("The Lord of the Rings").author("J.R.R. Tolkien").rating(9.3).availability("borrowed").build(),
                Book.builder().name("Harry Potter and the Philosopher's Stone").author("J.K. Rowling").rating(9.2).availability("available").build(),
                Book.builder().name("The Hobbit").author("J.R.R. Tolkien").rating(8.9).availability("available").build()

        );
        bookRepository.saveAll(movies);

        bookRepository.findAll().forEach((book ->
                System.out.println(book.toString())
        ));
    }
}
