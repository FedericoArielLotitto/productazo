package com.productazo.controller.rest;

import com.productazo.domain.Producto;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/api")
public class ProductoRestController {
    
    @GetMapping("/productos")
    public List<Producto> buscarTodos() {
        return new ArrayList<>();
    }
}
