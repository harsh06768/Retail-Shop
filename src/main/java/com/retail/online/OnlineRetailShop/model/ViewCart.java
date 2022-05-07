package com.retail.online.OnlineRetailShop.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.retail.online.OnlineRetailShop.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewCart {

    List<Optional<Product>> productList;
    double totalPrice ;
}
