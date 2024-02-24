package org.example.bookservice;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

//@Getter
//@Setter

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue()
    private long id;

    private String name;
    private String author;
    private String availability;
    private double rating;
}
