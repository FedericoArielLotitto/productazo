package com.productazo.service;

import com.productazo.builder.ProductoBuilder;
import com.productazo.domain.Producto;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class ProductoServiceTest {
    @Autowired
    private ProductoService productoService;
    @Autowired
    private EntityManager entityManager;
    
    @Test
    public void buscarTodos_conProductosExistentes_retornaProductos() {
        ProductoBuilder.completo().conNumeroDeSerie(new BigDecimal("14567867789897878387")).build(entityManager);
        ProductoBuilder.completo().conNumeroDeSerie(new BigDecimal("14567867789897878587")).build(entityManager);
        
        List<Producto> productos = productoService.buscarTodos();
        
        assertThat(productos).isNotEmpty().hasSize(2);
    }
    
    @Test
    public void buscarTodos_sinProductosExistentes_noRetornaProductos() {
        List<Producto> productos = productoService.buscarTodos();
        
        assertThat(productos).isEmpty();
    }
}
