package com.example.Act10.Service.Interface.domain;

import java.util.List;

import com.example.Act10.dtos.Request.ProductoCreateRequestodto;
import com.example.Act10.dtos.Response.ProductoResponseDto;

public interface IProductoService {

    ProductoResponseDto create(ProductoCreateRequestodto dto);

    List<ProductoResponseDto> getAll();
}