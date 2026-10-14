package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class CartController {
    
    private final CartService cartService;
    
    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        return ResponseEntity.ok(cartService.getAllCarts());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        return ResponseEntity.ok(cartService.getCartById(id));
    }
    
    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestParam String customerName, 
                                          @RequestParam String customerEmail) {
        Cart cart = cartService.createCart(customerName, customerEmail);
        return ResponseEntity.status(HttpStatus.CREATED).body(cart);
    }
    
    @PostMapping("/{cartId}/items")
    public ResponseEntity<Cart> addItemToCart(@PathVariable Long cartId,
                                               @RequestParam Long productId,
                                               @RequestParam Integer quantity) {
        Cart cart = cartService.addItemToCart(cartId, productId, quantity);
        return ResponseEntity.ok(cart);
    }
    
    @PutMapping("/{cartId}/items/{itemId}")
    public ResponseEntity<Cart> updateItemQuantity(@PathVariable Long cartId,
                                                  @PathVariable Long itemId,
                                                  @RequestParam Integer quantity) {
        Cart cart = cartService.updateItemQuantity(cartId, itemId, quantity);
        return ResponseEntity.ok(cart);
    }
    
    @DeleteMapping("/{cartId}/items/{itemId}")
    public ResponseEntity<Cart> removeItemFromCart(@PathVariable Long cartId,
                                                   @PathVariable Long itemId) {
        Cart cart = cartService.removeItemFromCart(cartId, itemId);
        return ResponseEntity.ok(cart);
    }
    
    @DeleteMapping("/{cartId}/clear")
    public ResponseEntity<Void> clearCart(@PathVariable Long cartId) {
        cartService.clearCart(cartId);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
}
