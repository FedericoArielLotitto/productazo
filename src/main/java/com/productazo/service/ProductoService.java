package com.productazo.service;

import com.productazo.domain.Producto;
import com.productazo.repository.ProductoRepository;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository productoRepository;
    
    public List<Producto> buscarTodos() {
        return productoRepository.findAll();
    }
}
