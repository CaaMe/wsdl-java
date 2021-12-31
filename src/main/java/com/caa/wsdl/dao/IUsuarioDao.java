package com.caa.wsdl.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.caa.wsdl.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {
	
	@Query("select u from Usuario u where u.username=?1 and u.password=?2")
	public Usuario findByUsernameAndPassword(String username, String password);

}

