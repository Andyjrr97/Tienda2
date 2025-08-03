package com.tienda.repository;

import com.tienda.domain.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.repository.query.Param;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE p.categoria.descripcion LIKE %:nombreCategoria%")
    List<Producto> findByCategoriaNombre(@Param("nombreCategoria") String nombreCategoria);
    List<Producto> findByCategoriaDescripcionContainingIgnoreCase(String nombreCategoria);

    //tarea grupal
    @Query("SELECT p FROM Producto p WHERE LOWER(p.categoria.descripcion) LIKE LOWER(CONCAT('%', :nombreCategoria, '%'))")
    List<Producto> buscarPorNombreCategoria(@Param("nombreCategoria") String nombreCategoria);

}
