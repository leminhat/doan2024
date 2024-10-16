package com.nhat.ecommerce.controller;


import com.nhat.ecommerce.exception.ProductException;
import com.nhat.ecommerce.model.Product;
import com.nhat.ecommerce.service.ProductService;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> findProductsByCategoryHandler(@RequestParam String category, @RequestParam List<String> color
            , @RequestParam List<String> size, @RequestParam Integer minPrice, @RequestParam Integer maxPrice, @RequestParam Integer minDiscount
            , @RequestParam String sort, @RequestParam String stock, @RequestParam Integer pageNumber, @RequestParam Integer pageSize) {

        Page<Product> res = productService.getAllProduct(category,color,size,minPrice,maxPrice,minDiscount,sort ,stock,pageNumber,pageSize);


        System.out.println("complete products");
        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }

    @GetMapping("/products/id/{productId}")
    public ResponseEntity<Product> findProductByIdHandler(@PathVariable Long productId) throws ProductException {

        Product product = productService.findProductById(productId);

        return new ResponseEntity<>(product,HttpStatus.ACCEPTED);

    }
//
//    @GetMapping("/products/search")
//    public ResponseEntity<List<Product>> searchProductHandler (@RequestParam String q){
//        List<Product> products = productService.searchProduct(q);
//
//        return new ResponseEntity<List<Product>>(products,HttpStatus.ACCEPTED);
//    }

}
