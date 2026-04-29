package com.example.Act10.dtos.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoResponseDto {
    private Long id;
    private String nombre;
    private Double precio;
}
