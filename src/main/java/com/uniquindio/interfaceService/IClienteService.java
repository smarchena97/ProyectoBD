package com.uniquindio.interfaceService;

import com.uniquindio.modelo.Cliente;

public interface IClienteService {
	
	public boolean verificarCliente(String email, String getpassword);

	public int saveCliente(Cliente p);

}
