package com.example.Act10;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Act10.Mapper.ProductoMapper;
import com.example.Act10.Models.Producto;
import com.example.Act10.Repository.IProductoRepository;
import com.example.Act10.Service.Impl.domain.ProductoService;
import com.example.Act10.dtos.Request.ProductoCreateRequestodto;
import com.example.Act10.dtos.Response.ProductoResponseDto;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceTest {

    @Mock
    private IProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @Test
    void deberiaCrearProductoCorrectamente() {

        
        ProductoCreateRequestodto dto = new ProductoCreateRequestodto();
        dto.setNombre("Teclado");
        dto.setPrecio(25000.0);

        Producto producto = ProductoMapper.toEntity(dto);

        when(productoRepository.save(any(Producto.class)))
                .thenReturn(producto);

        ProductoResponseDto resultado = productoService.create(dto);

        assertNotNull(resultado);
        assertEquals("Teclado", resultado.getNombre());

        verify(productoRepository).save(any(Producto.class));
    }

    @Test
    void deberiaRetornarListaDeProductos() {

        Producto producto = new Producto();
        producto.setNombre("Mouse");
        producto.setPrecio(10000.0);

        when(productoRepository.findAll())
                .thenReturn(List.of(producto));

        
        List<ProductoResponseDto> resultado = productoService.getAll();
        assertEquals(1, resultado.size());
        assertEquals("Mouse", resultado.get(0).getNombre());

        verify(productoRepository).findAll();
    }
}