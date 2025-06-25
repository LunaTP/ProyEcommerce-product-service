package com.proyCibertec.Aplication.mapper;

import com.proyCibertec.Domain.model.Producto;
import com.proyCibertec.Web.dto.ProductoResponseDto;

public class ProductoMapper {

    public static ProductoResponseDto toDto(Producto entity) {
        return new ProductoResponseDto(
                entity.getId(),
                entity.getNombre(),
                entity.getDescripcion(),
                entity.getPrecio(),
                entity.getStock()
        );
    }

    public static Producto toEntity(ProductoResponseDto dto) {
        return new Producto(
                dto.getId(),
                dto.getNombre(),
                dto.getDescripcion(),
                dto.getPrecio(),
                dto.getStock()
        );
    }
}
