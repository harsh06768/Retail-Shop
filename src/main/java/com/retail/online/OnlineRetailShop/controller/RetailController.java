package com.retail.online.OnlineRetailShop.controller;

import com.retail.online.OnlineRetailShop.entity.Product;
import com.retail.online.OnlineRetailShop.entity.User;
import com.retail.online.OnlineRetailShop.exception.CustomException;
import com.retail.online.OnlineRetailShop.model.ProductList;
import com.retail.online.OnlineRetailShop.model.ViewCart;
import com.retail.online.OnlineRetailShop.service.RetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/retail")
public class RetailController {

    @Autowired
    RetailService retailService;

    @PostMapping("/adduser")
    public ResponseEntity<User> addUser(@RequestBody User user) throws CustomException {
       return new ResponseEntity<>( retailService.addUser(user), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addproductinInventory")
    public ResponseEntity<Product> addProductInInventory(@RequestBody Product product) throws CustomException {
        return new ResponseEntity<Product>(retailService.addProductInInventory(product), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addProductInCartByUserIdAndProductId/{userId}/{pId}")
    public ResponseEntity<Product> addProductInCartByUserIdAndProductId(@PathVariable("userId") Long userId, @PathVariable("pId") Long pId ) throws CustomException {
                return new ResponseEntity<Product>(retailService.addProductInCartByUserIdAndProductId(userId, pId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getallproductsfromInventory")
    public ResponseEntity<ProductList>  listAllInventoryProduct(){
        return new ResponseEntity<ProductList>(retailService.listAllInventoryProduct(), HttpStatus.ACCEPTED);

    }

    @GetMapping("/getalluser")
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<List<User>>(retailService.getAllUser(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getCartItemsByUserId/{userId}")
    public ResponseEntity<Optional<ViewCart>> getCartItemByUserId(@PathVariable("userId") Long userId) throws CustomException {
       return new ResponseEntity<Optional<ViewCart>>(retailService.getCartItemByUserId(userId), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/delete/{userId}/{pId}")
    public ResponseEntity<String> deleteItemFromCart(@PathVariable("userId") Long userId , @PathVariable("pId") Long pId) throws CustomException {
        return new ResponseEntity<String>(retailService.deleteItemFromCart(userId, pId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateproductInInventory/{pId}")
    public ResponseEntity<Product> updateProductInInventory(@RequestBody Product product, @PathVariable("pId") Long pId) throws CustomException {
        return new ResponseEntity<Product>(retailService.updateProductInInventory(product, pId), HttpStatus.ACCEPTED);
    }

}
