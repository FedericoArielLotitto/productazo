package com.productazo.service;

import com.productazo.domain.Producto;
import java.util.List;


public interface ProductoService {

    List<Producto> buscarTodos();
    Producto crear(Producto productoNuevo);
}
