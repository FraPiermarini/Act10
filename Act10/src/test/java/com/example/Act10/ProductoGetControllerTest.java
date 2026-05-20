package com.example.Act10;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.Act10.Controllers.Get.ProductoGetController;
import com.example.Act10.Service.Interface.domain.IProductoService;
import com.example.Act10.dtos.Response.ProductoResponseDto;

@WebMvcTest(ProductoGetController.class)
public class ProductoGetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IProductoService productoService;

    @Test
    void deberiaRetornarListaDeProductos() throws Exception {

        ProductoResponseDto producto = new ProductoResponseDto();
        producto.setNombre("Mouse");
        producto.setPrecio(10000.0);

        when(productoService.getAll())
                .thenReturn(List.of(producto));

        mockMvc.perform(get("/productos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Mouse"))
                .andExpect(jsonPath("$[0].precio").value(10000.0));
    }
}