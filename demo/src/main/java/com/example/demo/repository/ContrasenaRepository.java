package com.example.demo.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Contrasena;

@Repository
public interface ContrasenaRepository extends JpaRepository<Contrasena, Long> {
	 @Query(value = "SELECT asignar_comision(:n_sales) FROM dual", nativeQuery = true)
	 String asignarComisionRepository(@Param("n_sales") int n_sales);

	 @Query(value = "SELECT calcular_factorial(:num) FROM dual", nativeQuery = true)
	 String calcularFactorialRepository(@Param("num") int num);
	 
	 @Query(value = "SELECT calcular_mcd(:num1, :num2) FROM dual", nativeQuery = true)
	 String calcularMcdRepository(@Param("num1") int num1, @Param("num2") int num2);
	 
	 @Query(value = "SELECT es_primo(:num) FROM dual", nativeQuery = true)
	 String esPrimoRepository(@Param("num") int num);
	 
	 @Query(value = "SELECT fibonacci(:num) FROM dual", nativeQuery = true)
	 String fibonacciRepository(@Param("num") int num);

	
}


