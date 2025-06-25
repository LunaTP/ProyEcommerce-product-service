package com.proyCibertec.Web.controller;

import com.proyCibertec.Web.dto.ProductoResponseDto;
import com.proyCibertec.Aplication.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<ProductoResponseDto> listarTodos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public ProductoResponseDto buscarPorId(@PathVariable Integer id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    public void registrar(@RequestBody ProductoResponseDto dto) {
        productoService.createProducto(dto);
    }

    @PutMapping
    public void actualizar(@RequestBody ProductoResponseDto dto) {
        productoService.updateProducto(dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        productoService.deleteProducto(id);
    }
}
