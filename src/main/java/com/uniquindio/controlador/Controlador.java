package com.uniquindio.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniquindio.interfaceService.IClienteService;
import com.uniquindio.interfaceService.IEmpleadoService;
import com.uniquindio.modelo.Cliente;
import com.uniquindio.modelo.Empleado;
import com.uniquindio.modelo.Persona;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IEmpleadoService service;
	
	@Autowired
	private IClienteService serviceCliente;
	
	@PostMapping("/login")
	public String logIn( @Validated Persona miE,  Model model) {
		boolean verify = service.verificar(miE.getEmail(), miE.getpassword());
		if(verify == true) {
			return "redirect:/empleado";
		}else {
			boolean verifyCliente = serviceCliente.verificarCliente(miE.getEmail(), miE.getpassword());
			if(verifyCliente == true) {
				return "redirect:/cliente";
			}
			return "redirect:/inicio";
		}
		
	}
	
	@GetMapping("/inicio")
	public String iniciar(Model model) {
		
		return "login";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		List<Empleado> empleado = service.listar();
		model.addAttribute("Empleados", empleado);
		return "index";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("Empleado", new Empleado());
		return "formulario";
	}
	
	@PostMapping("/save")
	public String save(@Validated Empleado e, Model model) {
		
		service.save(e);
		return "redirect:/listar";
	}
	
	@PostMapping("/saveCliente")
	public String save(@Validated Cliente e, Model model) {
		serviceCliente.saveCliente(e);
		return "redirect:/cliente";
	}
	
	@GetMapping("/editar/{cedula}")
	public String editar(@PathVariable Integer cedula,Model model) {
		Optional<Empleado> miE = service.listarId(cedula);
		model.addAttribute("Empleado", miE);
		return "formulario";
	}
	
	@GetMapping("/eliminar/{cedula}")
	public String delete(@PathVariable Integer cedula,Model model) {
		service.delete(cedula);
		return "redirect:/listar";
	}
	
	@GetMapping("/cliente")
	public String visualCliente(Model model) {
		return "vistaCliente";
	}
	
	@GetMapping("/empleado")
	public String visualEmpleado(Model model) {
		return "vistaEmpleado";
	}
	
	@GetMapping("/productos")
	public String mostrarProductos(Model model) {
		return "productos";
	}
}
