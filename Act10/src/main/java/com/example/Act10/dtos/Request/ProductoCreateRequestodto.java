package com.example.Act10.dtos.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoCreateRequestodto {
    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "El precio es requerido")
    private Double precio;
}
