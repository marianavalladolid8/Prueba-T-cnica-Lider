package com.tuapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "cliente")  // Asegúrme de que el nombre coincida con la tabla en MySQL
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;
    
//creado para clientecontrollertest :(
    public Cliente(long l, String string, String string2) {
		// TODO Auto-generated constructor stub
	}
//creado porque marcaba erro en clienteservicetest
	public Cliente() {
		// constructor vacio requerido por JPA
	}

	// Getters y setters 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

	
}// cierre clase principal

