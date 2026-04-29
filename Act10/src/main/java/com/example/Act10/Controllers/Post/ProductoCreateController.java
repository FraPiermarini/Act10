package com.example.Act10.Controllers.Post;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Act10.Service.Interface.domain.IProductoCreateService;
import com.example.Act10.dtos.Request.ProductoCreateRequestodto;
import com.example.Act10.dtos.Response.ProductoResponseDto;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoCreateController {
    private final IProductoCreateService productoCreateService;

    @PostMapping
    public ResponseEntity<ProductoResponseDto> create(
        @Valid @RequestBody ProductoCreateRequestodto dto){
            ProductoResponseDto producto = productoCreateService.create(dto);
            return ResponseEntity.ok(producto);
        }
}
