package com.caa.wsdl.service;

import java.util.List;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitUniqueKeyNameSource;
import org.hibernate.boot.spi.MetadataBuildingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caa.wsdl.dao.IUsuarioDao;
import com.caa.wsdl.entity.Usuario;
import com.caa.wsdl.helper.Status;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao repositoryUsuario;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) repositoryUsuario.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Integer id) {
		return repositoryUsuario.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Status findByUsernameAndPassword(String username, String password) {
		try {
			Usuario usuario = null;
			usuario = repositoryUsuario.findByUsernameAndPassword(username, password);
			if (usuario == null) {
				return Status.FAILURE;
			}
			return Status.SUCESS;
		} catch (Exception e) {
			return Status.FAILURE;
		}
	}

	@Override
	@Transactional
	public Status save(Usuario usuario) {

		try {
			repositoryUsuario.save(usuario);
			return Status.SUCESS;
		} catch (Exception e) {
			return Status.FAILURE;
		}
	}

	@Override
	@Transactional
	public Status delete(Integer id) {
		try {
			repositoryUsuario.deleteById(id);
			return Status.SUCESS;
		} catch (Exception e) {
			return Status.FAILURE;
		}
	}
}
