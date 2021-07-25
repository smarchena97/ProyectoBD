package com.uniquindio.service;

import java.util.List;
import java.util.Optional;

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
	public int saveCliente(Cliente p) {
		// TODO Auto-generated method stub
		int res = 0;
		Cliente e = data.save(p);
		if(!e.equals(null)) {
			res = 1;
		}
		return res;
	}
	
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
	
	
	@Override
	public Cliente listarClienteId(Integer id) {
		List<Cliente> miE = (List<Cliente>) data.findAll();
		for (Cliente cliente: miE) {
			if (cliente.getCedula().equals(id)) {
				return cliente;
			}
		}
		return null;
	}

}
