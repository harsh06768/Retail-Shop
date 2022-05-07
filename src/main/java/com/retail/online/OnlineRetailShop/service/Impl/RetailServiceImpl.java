package com.retail.online.OnlineRetailShop.service.Impl;

import com.retail.online.OnlineRetailShop.Util.CartIdGeneration;
import com.retail.online.OnlineRetailShop.entity.Cart;
import com.retail.online.OnlineRetailShop.entity.Product;
import com.retail.online.OnlineRetailShop.entity.User;
import com.retail.online.OnlineRetailShop.exception.CustomException;
import com.retail.online.OnlineRetailShop.model.ProductList;
import com.retail.online.OnlineRetailShop.model.ViewCart;
import com.retail.online.OnlineRetailShop.repository.CartRepository;
import com.retail.online.OnlineRetailShop.repository.ProductRepository;
import com.retail.online.OnlineRetailShop.repository.UserRepository;
import com.retail.online.OnlineRetailShop.service.RetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class RetailServiceImpl implements RetailService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;

    @Override
    public User addUser(User user) throws CustomException {

        Long checkUser = user.getUserId();

        if(userRepository.findById(checkUser).isPresent()){
            throw new CustomException("User already exist",
                    "User with Id: "+checkUser+" already Exist in Database");
        }

        System.out.println("Inside save user" + user);
        CartIdGeneration cartIdGeneration = new CartIdGeneration();
        String uuid = cartIdGeneration.generateCartId();
        user.setCartId(uuid);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Product addProductInCartByUserIdAndProductId(Long userId, Long pId) throws CustomException {

        if(userRepository.findById(userId).isEmpty()){
            throw new CustomException("User does not exist",
                    "User with Id: "+userId+" does not Exist in Database.");
        }
        if(productRepository.findById(pId).isEmpty()){
            throw new CustomException("Product is not Available in Inventory","Product with Id: "+pId
                    +" is not availabe in Inventory");
        }

        Optional<User> user = userRepository.findById(userId);
        Optional<Product> product = productRepository.findById(pId);
        User users = user.get();

        String cartId = users.getCartId();
        Cart cart = new Cart();
        cart.setCartId(cartId);
        cart.setProdId(pId);
        cartRepository.save(cart);

        Product products = product.get();

        return products;
    }

    @Override
    public Optional<ViewCart> getCartItemByUserId(Long userId) throws  CustomException{

        if(userRepository.findById(userId).isEmpty()){
            throw new CustomException("User does not exist",
                    "User with Id: "+userId+" does not Exist in Database.");
        }

        Optional<User> user = userRepository.findById(userId);
        User users = user.get();
        List<Optional<Product>> productList = new ArrayList<>();
        String cartId = users.getCartId();
        double totalAmount = 0.0;
        List<Cart> cartList = new ArrayList<>();
        cartList = cartRepository.findAll();
        for (Cart cart : cartList) {
            if ((cart.getCartId().equals(cartId))) {
                productList.add(productRepository.findById(cart.getProdId()));
            }
        }

//        // converting Optional List of Product to List of Product
//        List<Product> collect = productList.stream()
//                .flatMap(Optional::stream)
//                .collect(Collectors.toList());

        for (Optional<Product> p : productList) {
            totalAmount = totalAmount + p.get().getPPrice();
        }
        ViewCart viewCart = new ViewCart();
        viewCart.setProductList(productList);
        viewCart.setTotalPrice(totalAmount);

        return Optional.of(viewCart);
    }

    @Override
    public String deleteItemFromCart(Long userId, Long pId) throws  CustomException{

        if(userRepository.findById(userId).isEmpty()){
            throw new CustomException("User does not exist",
                    "User with Id: "+userId+" does not Exist in Database.");
        }
        if(productRepository.findById(pId).isEmpty()){
            throw new CustomException("Product is not Available in Inventory","Product with Id: "+pId
                    +" is not availabe in Inventory");
        }


        Optional<User> user = userRepository.findById(userId);
        User users = user.get();
        String cartId = users.getCartId();

        List<Cart> cartList = cartRepository.findAll();
        List<Cart> cartListstore = new ArrayList<>();
        for (Cart cart : cartList) {
            if (cart.getCartId().equals(cartId)) {
                cartListstore.add(cart);
            }
        }
        System.out.println("cartList Store"+ cartListstore);
        if(cartListstore.isEmpty()){
             throw new CustomException("Cart is Empty","There is no Item in your cart. Add the item first");
        }

        for (Cart cart : cartListstore) {
            if (cart.getProdId().equals(pId)) {
                cartRepository.delete(cart);
            }
        }
        return "Product with Id: " + pId + " deleted successfully";
    }

    @Override
    public Product addProductInInventory(Product product) throws CustomException{

        if(productRepository.findById(product.getPId()).isPresent()){
            throw new CustomException("Product is already Available in Inventory","Product with Id: "+product.getPId()
                    +" is already availabe in Inventory");
        }

        System.out.println("Inside save product" + product);
        product  = productRepository.save(product);
        return product;
    }

    @Override
    public Product updateProductInInventory(Product product, long pId) throws CustomException{

        if(productRepository.findById(pId).isEmpty()){
            throw new CustomException("Product is not Available in Inventory","Product with Id: "+product.getPId()
                    +" is not availabe in Inventory");
        }

        Optional<Product> products = productRepository.findById(pId);
        Product product1 = products.get();
        product1.setPId(product.getPId());
        product1.setPName(product.getPName());
        product1.setPPrice(product.getPPrice());
        productRepository.save(product1);
        return product1;
    }

    @Override
    public ProductList listAllInventoryProduct() {
        return ProductList.listAllProduct();
    }

    }


