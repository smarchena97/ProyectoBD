package com.uniquindio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniquindio.interfaceService.IClienteService;
import com.uniquindio.interfaces.ICliente;
import com.uniquindio.modelo.Cliente;

@Service
public class ClienteService implements IClienteService{
	
	@Autowired
	private ICliente data;
	
	
	
	@Override
	public boolean verificarCliente(String email, String password) {
		boolean centi = false;
		List<Cliente> miE = (List<Cliente>) data.findAll();
		for (Cliente cliente: miE) {
			String auxEmail = cliente.getEmail();
			String auxPassword = cliente.getPassword();
			if(auxEmail.equals(email) && auxPassword.equals(password)) {
				centi = true;
			}
		}
		return centi;
	}

}
