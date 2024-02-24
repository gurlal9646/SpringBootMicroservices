package org.example.borrowservice;

import lombok.*;

//@Getter
//@Setter

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private long id;
    private String name;
    private String author;
    private String availability;
    private double rating;
}
