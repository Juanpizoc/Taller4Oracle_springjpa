package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Contrasena;
import com.example.demo.repository.ContrasenaRepository;
import com.example.demo.services.ContrasenaService;

@RestController
public class ContrasenaController {
	@Autowired 
	private ContrasenaRepository repository;
	@Autowired
	private ContrasenaService services;
	
	
	@PostMapping("/contrasena")
	private ResponseEntity<Contrasena> guardarContrasena(@RequestBody Contrasena contrasena){
		Contrasena contra = services.guardarContrasena(contrasena);
		return new ResponseEntity<>(contra,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/user/{id}") 
	private ResponseEntity<Contrasena> leerUsuario (@PathVariable Long id) {
		ResponseEntity<Contrasena> response = services.leerUsuario(id);
		return response;
	}
	
	
	@GetMapping("/users")
	public ResponseEntity<List<Contrasena>> obtenerUsuarios(){
		ResponseEntity<List<Contrasena>> response = services.obtenerUsuarios();
		return response;
	}

	
	@PutMapping("/user/{id}")
	private ResponseEntity<Contrasena> actualizarUsuario(@PathVariable Long id, @RequestBody Contrasena update){
		ResponseEntity<Contrasena> response = services.actualizarUsuario(id,update);
		return response;
		
	}
	
	@DeleteMapping("/user/{id}")
	private ResponseEntity<Contrasena> eliminarUsuario(@PathVariable Long id){
		ResponseEntity<Contrasena> response = services.eliminarUsuario(id);
		return response;
	}
	@PostMapping("/funcion/{dato}")
	private ResponseEntity<String> llamarFuncion(@PathVariable int dato ){
		String response = services.asignarComision(dato);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/factorial/{num}")
	private ResponseEntity<String> llamarFactorial(@PathVariable int num) {
	    String resultado = repository.calcularFactorialRepository(num);
	    return new ResponseEntity<>("El factorial de " + num + " es: " + resultado, HttpStatus.OK);
	}
	
	@PostMapping("/mcd/{num1}/{num2}")
    private ResponseEntity<String> calcularMcd(@PathVariable int num1, @PathVariable int num2) {
        String resultado = repository.calcularMcdRepository(num1, num2);
        return new ResponseEntity<>("El MCD de " + num1 + " y " + num2 + " es: " + resultado, HttpStatus.OK);
    }
	
	@PostMapping("/esPrimo/{num}")
    private ResponseEntity<String> verificarPrimo(@PathVariable int num) {
        String resultado = repository.esPrimoRepository(num);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
	
	@PostMapping("/fibonacci/{num}")
    private ResponseEntity<String> generarFibonacci(@PathVariable int num) {
        String resultado = repository.fibonacciRepository(num);
        return new ResponseEntity<>("La serie de Fibonacci de " + num + " es: " + resultado, HttpStatus.OK);
    }

}


