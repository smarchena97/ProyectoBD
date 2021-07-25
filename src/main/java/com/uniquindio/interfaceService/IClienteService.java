package com.uniquindio.interfaceService;

import java.util.Optional;

import com.uniquindio.modelo.Cliente;

public interface IClienteService {
	
	public boolean verificarCliente(String email, String getpassword);

	public int saveCliente(Cliente p);

	public Cliente listarClienteId(Integer id);

}
