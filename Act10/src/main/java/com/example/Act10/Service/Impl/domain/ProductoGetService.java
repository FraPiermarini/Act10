package com.example.Act10.Service.Impl.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Act10.Mapper.ProductoMapper;
import com.example.Act10.Repository.IProductoRepository;
import com.example.Act10.Service.Interface.domain.IProductoGetService;
import com.example.Act10.dtos.Response.ProductoResponseDto;

@Service
public class ProductoGetService implements IProductoGetService{
    private final IProductoRepository productoRepository;

    public ProductoGetService(IProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }
    @Override
    public List<ProductoResponseDto> getAll(){
        return productoRepository.findAll()
        .stream()
        .map(ProductoMapper::toResponseDto)
        .collect(Collectors.toList());
    }
    
}
