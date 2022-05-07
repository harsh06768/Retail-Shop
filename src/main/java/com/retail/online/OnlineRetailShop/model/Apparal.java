package com.retail.online.OnlineRetailShop.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.retail.online.OnlineRetailShop.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Apparal extends Product {

    private Long apparaId;
    private String type;
    private String brand;
    private String design;

     public static Apparal buildApparalDetails(){

        Apparal apparal=new Apparal();

        apparal.setPId(54353L);
        apparal.setPName("apparal");
        apparal.setPPrice(8999);
        apparal.setApparaId(54353L);
        apparal.setType("Woolen");
        apparal.setBrand("Gucci");
        apparal.setDesign("Party Wear");
        System.out.println("Inside Apparal"+ apparal);

        return apparal;
    }
}

