package com.caa.wsdl.service;

import java.util.List;

import com.caa.wsdl.entity.Usuario;
import com.caa.wsdl.helper.Status;

public interface IUsuarioService {

	public List<Usuario> findAll();
	
	public Usuario findById(Integer id);

	public Status save(Usuario usuario);
	
	public Status delete(Integer id);
	
	public Status findByUsernameAndPassword(String username, String password);
}
