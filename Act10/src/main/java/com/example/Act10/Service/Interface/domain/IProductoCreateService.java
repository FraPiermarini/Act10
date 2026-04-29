package com.example.Act10.Service.Interface.domain;

import com.example.Act10.dtos.Request.ProductoCreateRequestodto;
import com.example.Act10.dtos.Response.ProductoResponseDto;

public interface IProductoCreateService {
    ProductoResponseDto create(ProductoCreateRequestodto dto);
}
