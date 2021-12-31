package com.caa.wsdl.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.caa.wsdl.entity.Usuario;
import com.caa.wsdl.exception.UsuarioNotFoundException;
import com.caa.wsdl.service.IUsuarioService;

import wsdl.com.DeleteUserRequest;
import wsdl.com.DeleteUserResponse;
import wsdl.com.GetAllUserDetailRequest;
import wsdl.com.GetAllUserDetailResponse;
import wsdl.com.GetLoginRequest;
import wsdl.com.GetLoginResponse;
import wsdl.com.GetUserDetailRequest;
import wsdl.com.GetUserDetailResponse;
import wsdl.com.InsertUserRequest;
import wsdl.com.InsertUserResponse;
import wsdl.com.UserDetail;

@Endpoint
@CrossOrigin(origins = {"*", "http://localhost:4200"}, allowCredentials = "false")
public class UsuarioEndPoint {
	
	@Autowired
	private IUsuarioService service;
	
	@PayloadRoot(namespace = "http://com.wsdl" , localPart = "GetUserDetailRequest")
	@ResponsePayload
	public GetUserDetailResponse processUserDetailRequest(@RequestPayload GetUserDetailRequest req) throws Exception {
		Usuario usuario = service.findById(req.getId());
		if(usuario == null) {
			throw new UsuarioNotFoundException("El Id del Usuario es incorrecto " + req.getId() + " favor de verificar");
		}
		return convertToGetUserDetailResponse(usuario);
	}
	
	private GetUserDetailResponse convertToGetUserDetailResponse(Usuario usuario) {
		GetUserDetailResponse resp = new GetUserDetailResponse();
		resp.setUserDetail(convertToUserDetail(usuario));
		return resp;
	}
	
	private UserDetail convertToUserDetail(Usuario usuario) {
		
		UserDetail usuarioDetail = new UserDetail();
		usuarioDetail.setId(usuario.getId());
		usuarioDetail.setNombre(usuario.getNombre());
		usuarioDetail.setApellido(usuario.getApellido());
		usuarioDetail.setUsername(usuario.getUsername());
		usuarioDetail.setPassword(usuario.getPassword());
		
		return usuarioDetail;
	}

	@PayloadRoot(namespace = "http://com.wsdl" , localPart = "GetAllUserDetailRequest")
	@ResponsePayload
	public GetAllUserDetailResponse processGetAllUserDetailRequest(@RequestPayload GetAllUserDetailRequest req) {
		List<Usuario> usuarios = service.findAll();
		return convertToGetAllUserDetailResponse(usuarios);
	}	
	
	private GetAllUserDetailResponse convertToGetAllUserDetailResponse(List<Usuario> usuarios) {
		GetAllUserDetailResponse resp = new GetAllUserDetailResponse();
		
		usuarios.stream().forEach(c -> resp.getUserDetail().add(convertToUserDetail(c)));
		
		return resp;
	}

	@PayloadRoot(namespace = "http://com.wsdl" , localPart = "DeleteUserRequest")
	@ResponsePayload
	public DeleteUserResponse deleteUserRequest(@RequestPayload DeleteUserRequest req) {
		DeleteUserResponse resp = new DeleteUserResponse();
		resp.setStatus(convertStatusSoap(service.delete(req.getId())));
		return resp;
	}
	
	private wsdl.com.Status convertStatusSoap(
			com.caa.wsdl.helper.Status statusSer) {
		if(statusSer == com.caa.wsdl.helper.Status.FAILURE) {
			return wsdl.com.Status.FAILURE;
		}
		return wsdl.com.Status.SUCCESS;
	}
	
	@PayloadRoot(namespace = "http://com.wsdl" , localPart = "InsertUserRequest")
	@ResponsePayload
	public InsertUserResponse insertUserRequest(@RequestPayload InsertUserRequest req) {
		InsertUserResponse resp = new InsertUserResponse();
		resp.setStatus(convertStatusSoap(service.save(convertUser(req.getUserDetail()))));
		return resp;
	}
	
	private Usuario convertUser(UserDetail usuario) {
		return new Usuario(
				usuario.getId(),
				usuario.getNombre(),
				usuario.getApellido(),
				usuario.getUsername(),
				usuario.getPassword());
	}

	@PayloadRoot(namespace = "http://com.wsdl" , localPart = "GetLoginRequest")
	@ResponsePayload
	public GetLoginResponse LoginUserRequest(@RequestPayload GetLoginRequest req) {
		GetLoginResponse resp = new GetLoginResponse();
		resp.setStatus(convertStatusSoap(
				service.findByUsernameAndPassword(req.getUsername(), req.getPassword())));
		return resp;
	}
}
