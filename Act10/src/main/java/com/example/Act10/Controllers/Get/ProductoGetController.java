package com.example.Act10.Controllers.Get;

import org.springframework.web.bind.annotation.RestController;

import com.example.Act10.Service.Interface.domain.IProductoGetService;
import com.example.Act10.dtos.Response.ProductoResponseDto;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ProductoGetController {
    private final IProductoGetService service;
    public ProductoGetController(IProductoGetService service){
        this.service = service;
    } 
    @GetMapping("/productos")
    public List<ProductoResponseDto> getAll(){
        return service.getAll();
    }
}
