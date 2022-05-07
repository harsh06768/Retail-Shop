package com.retail.online.OnlineRetailShop.service;

import com.retail.online.OnlineRetailShop.entity.Product;
import com.retail.online.OnlineRetailShop.entity.User;
import com.retail.online.OnlineRetailShop.exception.CustomException;
import com.retail.online.OnlineRetailShop.model.ProductList;
import com.retail.online.OnlineRetailShop.model.ViewCart;
import java.util.List;
import java.util.Optional;

public interface RetailService {
    public Product addProductInInventory(Product product) throws CustomException ;
    public Product updateProductInInventory(Product product, long pId) throws CustomException ;
    public ProductList listAllInventoryProduct();
    public  User addUser(User user) throws CustomException;
    public List<User> getAllUser();
    public Product addProductInCartByUserIdAndProductId(Long userId, Long pId) throws CustomException ;
    public Optional<ViewCart> getCartItemByUserId(Long userId) throws CustomException ;
    public String deleteItemFromCart(Long userId ,Long pId) throws CustomException ;

}
