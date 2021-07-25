package com.uniquindio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniquindio.interfaceService.IProductoService;
import com.uniquindio.interfaces.IProducto;
import com.uniquindio.modelo.Producto;

@Service
public class ProductoService implements IProductoService{

	@Autowired
	private IProducto data;
	
	@Override
	public List<Producto> listarProductos() {
		return (List<Producto>)data.findAll();
	}
	
}
