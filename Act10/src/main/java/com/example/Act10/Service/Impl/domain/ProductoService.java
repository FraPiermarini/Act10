package com.example.Act10.Service.Impl.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Act10.Mapper.ProductoMapper;
import com.example.Act10.Models.Producto;
import com.example.Act10.Repository.IProductoRepository;
import com.example.Act10.Service.Interface.domain.IProductoService;
import com.example.Act10.dtos.Request.ProductoCreateRequestodto;
import com.example.Act10.dtos.Response.ProductoResponseDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoService implements IProductoService {

    private final IProductoRepository productoRepository;

    @Override
    public ProductoResponseDto create(ProductoCreateRequestodto dto){

        Producto productoGuardar = ProductoMapper.toEntity(dto);

        Producto productoGuardado = productoRepository.save(productoGuardar);

        return ProductoMapper.toResponseDto(productoGuardado);
    }

    @Override
    public List<ProductoResponseDto> getAll(){

        return productoRepository.findAll()
                .stream()
                .map(ProductoMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}