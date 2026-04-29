package com.example.Act10.Mapper;

import com.example.Act10.Models.Producto;
import com.example.Act10.dtos.Request.ProductoCreateRequestodto;
import com.example.Act10.dtos.Response.ProductoResponseDto;

public class ProductoMapper {
    public static Producto toEntity(ProductoCreateRequestodto dto){
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        return producto;
    }
    public static ProductoResponseDto toResponseDto(Producto producto){
        ProductoResponseDto dto = new ProductoResponseDto();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        return dto;
    }
}
