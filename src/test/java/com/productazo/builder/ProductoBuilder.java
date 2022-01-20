package com.productazo.builder;

import com.productazo.domain.Producto;
import java.math.BigDecimal;
import javax.persistence.EntityManager;

public class ProductoBuilder {

    private Producto instance;

    public ProductoBuilder() {
        instance = new Producto();
    }

    public static ProductoBuilder completo() {
        ProductoBuilder builder = new ProductoBuilder();
        builder.instance.setNombre("producto prueba");
        builder.instance.setNumeroDeSerie(new BigDecimal("14561243673879652786"));
        builder.instance.setMarca("marca de prueba");
        builder.instance.setCantidad(24L);
        return builder;
    }
    
    public ProductoBuilder conNumeroDeSerie(BigDecimal numeroDeSerie) {
        this.instance.setNumeroDeSerie(numeroDeSerie);
        return this;
    }

    public Producto build(EntityManager entityManager) {
        entityManager.persist(instance);
        entityManager.flush();
        entityManager.detach(instance);
        return instance;
    }
}
