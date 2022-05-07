package com.retail.online.OnlineRetailShop.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.retail.online.OnlineRetailShop.entity.Product;
import com.retail.online.OnlineRetailShop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Book extends Product {

    private Long bookId;
    private String genre;
    private String author;
    private String publications;

        public static Book buildBookDetails() {

                Book book = new Book();
                book.setPId(3243L);
                book.setPName("book");
                book.setPPrice(500);
                book.setBookId(3243L);
                book.setGenre("Fantasy");
                book.setAuthor("J.K Rowling");
                book.setPublications("J.K Publications");
                System.out.println("Inside the book:" + book);

                return book;
        }

    }

