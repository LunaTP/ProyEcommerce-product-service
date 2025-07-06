package com.proyCibertec.Web.controller;

import com.proyCibertec.Web.dto.ProductoResponseDto;
import com.proyCibertec.Aplication.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping("/listar")
    public List<ProductoResponseDto> listarTodos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/buscar/{id}")
    public ProductoResponseDto buscarPorId(@PathVariable Integer id) {
        return productoService.getProductoById(id);
    }

    @PostMapping("/crear")
    public void registrar(@RequestBody ProductoResponseDto dto) {
        productoService.createProducto(dto);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody ProductoResponseDto dto) {
        productoService.updateProducto(dto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        productoService.deleteProducto(id);
    }
}
