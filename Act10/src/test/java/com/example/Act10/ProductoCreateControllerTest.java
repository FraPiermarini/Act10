package com.example.Act10;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.example.Act10.Controllers.Post.ProductoCreateController;
import com.example.Act10.Service.Interface.domain.IProductoService;
import com.example.Act10.dtos.Request.ProductoCreateRequestodto;
import com.example.Act10.dtos.Response.ProductoResponseDto;

import tools.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;

import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.bean.override.mockito.MockitoBean;

import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProductoCreateController.class)
@ContextConfiguration(classes = Act10Application.class)
public class ProductoCreateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IProductoService productoCreateService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deberiaCrearProducto() throws Exception {

        ProductoCreateRequestodto dto = new ProductoCreateRequestodto();
        dto.setNombre("Teclado");
        dto.setPrecio(25000.0);

        ProductoResponseDto response = new ProductoResponseDto();
        response.setNombre("Teclado");
        response.setPrecio(25000.0);

        when(productoCreateService.create(any(ProductoCreateRequestodto.class)))
                .thenReturn(response);

        mockMvc.perform(post("/productos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Teclado"))
                .andExpect(jsonPath("$.precio").value(25000.0));
    }
}