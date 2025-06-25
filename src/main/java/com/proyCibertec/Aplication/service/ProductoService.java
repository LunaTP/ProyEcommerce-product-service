package com.proyCibertec.Aplication.service;

import com.proyCibertec.Web.dto.ProductoResponseDto;


import java.util.List;

public interface ProductoService {
    List<ProductoResponseDto> getAllProductos();
    ProductoResponseDto getProductoById(Integer id);
    void createProducto(ProductoResponseDto dto);
    void updateProducto(ProductoResponseDto dto);
    void deleteProducto(Integer id);
}
