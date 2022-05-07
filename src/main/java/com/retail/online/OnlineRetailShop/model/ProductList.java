package com.retail.online.OnlineRetailShop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductList {
    Book book;
    Apparal apparal;

    public static ProductList listAllProduct(){

        Book book = Book.buildBookDetails();
        Apparal apparal = Apparal.buildApparalDetails();

        ProductList productList=new ProductList();
        productList.setBook(book);
        productList.setApparal(apparal);

        return productList;
    }
}
