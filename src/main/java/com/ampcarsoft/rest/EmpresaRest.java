package com.ampcarsoft.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ampcarsoft.entity.Empresa;
import com.ampcarsoft.repository.EmpresaRepository;

@RestController
public class EmpresaRest {

	@Autowired
	private EmpresaRepository dao;

	@PostMapping("/createEmpresa")
	public Empresa insertar(@RequestBody Empresa empresa) {
		return dao.save(empresa);
	}

	@PutMapping("/updateEmpresa")
	public Empresa modificar(@RequestBody Empresa empresa) {
		return dao.save(empresa);
	}

	@DeleteMapping("/deleteEmpresa/{cif}")
	public void borrar(@PathVariable String cif) {
		dao.deleteById(cif);
	}

	@GetMapping("/getEmpresa/{cif}")
	public Empresa seleccionar(@PathVariable String cif) {
		Optional<Empresa> c = dao.findById(cif);
		return c.get();
	}

	@GetMapping("/allEmpresa")
	public List<Empresa> getListadoEmpresas() {
		return (List<Empresa>) dao.findAll();
	}

}
