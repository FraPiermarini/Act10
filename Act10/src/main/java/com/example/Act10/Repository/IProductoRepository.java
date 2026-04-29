package com.example.Act10.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Act10.Models.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long>{
} 