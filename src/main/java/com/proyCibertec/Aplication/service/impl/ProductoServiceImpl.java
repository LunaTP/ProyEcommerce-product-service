package com.proyCibertec.Aplication.service.impl;

import com.proyCibertec.Web.dto.ProductoResponseDto;
import com.proyCibertec.Aplication.service.ProductoService;
import com.proyCibertec.Domain.model.Producto;
import com.proyCibertec.Domain.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<ProductoResponseDto> getAllProductos() {
        return StreamSupport
                .stream(productoRepository.findAll().spliterator(), false)
                .map(producto -> new ProductoResponseDto(
                        producto.getId(),
                        producto.getNombre(),
                        producto.getDescripcion(),
                        producto.getPrecio(),
                        producto.getStock()
                ))
                .toList();
    }

    @Override
    public ProductoResponseDto getProductoById(Integer id) {
        return productoRepository.findById(id)
                .map(producto -> new ProductoResponseDto(
                        producto.getId(),
                        producto.getNombre(),
                        producto.getDescripcion(),
                        producto.getPrecio(),
                        producto.getStock()
                ))
                .orElse(null);
    }

    @Override
    public void createProducto(ProductoResponseDto dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        productoRepository.save(producto);
    }

    @Override
    public void updateProducto(ProductoResponseDto dto) {
        Optional<Producto> optionalProducto = productoRepository.findById(dto.getId());
        optionalProducto.ifPresent(producto -> {
            producto.setNombre(dto.getNombre());
            producto.setDescripcion(dto.getDescripcion());
            producto.setPrecio(dto.getPrecio());
            producto.setStock(dto.getStock());
            productoRepository.save(producto);
        });
    }

    @Override
    public void deleteProducto(Integer id) {
        productoRepository.deleteById(id);
    }
}
