package com.productazo.service.impl;

import com.productazo.domain.Producto;
import com.productazo.repository.ProductoRepository;
import com.productazo.service.ProductoService;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Transactional
@RequiredArgsConstructor
@Validated
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public List<Producto> buscarTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto crear(Producto productoNuevo) {
        validarProducto(productoNuevo);
        return productoRepository.save(productoNuevo);
    }

    private void validarProducto(Producto productoNuevo) {
        if(productoNuevo == null) throw new IllegalArgumentException("El producto a crear no puede ser nulo.");
    }
}
