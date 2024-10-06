package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Contrasena;
import com.example.demo.repository.ContrasenaRepository;

@Service
public class ContrasenaService {
	@Autowired 
	private ContrasenaRepository repository;
	
	public Contrasena guardarContrasena( Contrasena contrasena ) {
		Contrasena contra = repository.save(contrasena);
		return contra;
	}
	public String asignarComision(int n_sales) {
        return repository.asignarComisionRepository(n_sales);
    }
	
	public ResponseEntity<Contrasena> leerUsuario (Long id){
		Optional<Contrasena> user = repository.findById(id);
		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<List<Contrasena>> obtenerUsuarios(){
	    List<Contrasena> users = repository.findAll();
	    if (users.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	public ResponseEntity<Contrasena> actualizarUsuario( Long id, Contrasena update){
		Optional<Contrasena> existentUser = repository.findById(id);
		if (existentUser.isPresent()) {
	        Contrasena user = existentUser.get();
	      
	        user.setPassword(update.getPassword());
	        user.setUsername(update.getUsername());
	        
	        Contrasena updateUser = repository.save(user);
	        return new ResponseEntity<>(updateUser, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
		
	}
	public ResponseEntity<Contrasena> eliminarUsuario(Long id){
		Optional<Contrasena> existentUser = repository.findById(id);
		if (existentUser.isPresent()) {
	        repository.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }	
	}
}
