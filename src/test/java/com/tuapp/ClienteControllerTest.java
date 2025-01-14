package com.tuapp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.tuapp.controller.ClienteController;
import com.tuapp.model.Cliente;
import com.tuapp.repository.ClienteRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Optional;

@WebMvcTest(ClienteController.class) // Clase de prueba para el ClienteController
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // Simula el repositorio para no acceder a una base de datos real
    private ClienteRepository clienteRepository;

    @BeforeEach // Método que se ejecuta antes de cada prueba para configurar el entorno
    public void setUp() {
        // Datos de prueba
        Cliente cliente1 = new Cliente(1L, "Juan", "juan@example.com");
        Cliente cliente2 = new Cliente(2L, "Maria", "maria@example.com");

        // Simular respuestas del repositorio
        when(clienteRepository.findAll()).thenReturn(List.of(cliente1, cliente2));
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente1));
        when(clienteRepository.findById(99L)).thenReturn(Optional.empty());
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente1);
    }

    @Test // Prueba para obtener un cliente por su ID (GET /clientes/{id})
    public void testObtenerClientes() throws Exception {
        mockMvc.perform(get("/clientes"))  // Configura el comportamiento esperado del repositorio simulado
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Juan"))
                .andExpect(jsonPath("$[0].correo").value("juan@example.com"))
                .andExpect(jsonPath("$[1].nombre").value("Maria"))
                .andExpect(jsonPath("$[1].correo").value("maria@example.com"));
    }

    @Test // Prueba para crear un nuevo cliente (POST /clientes)
    public void testCrearCliente() throws Exception {
        String clienteJson = "{\"nombre\": \"Juan\", \"correo\": \"juan@example.com\"}";
        // Realiza la petición GET y valida el resultado
        mockMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(clienteJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre").value("Juan"))
                .andExpect(jsonPath("$.correo").value("juan@example.com"));
    }

    @Test // Prueba para actualizar un cliente existente (PUT /clientes/{id})
    public void testObtenerClientePorIdExistente() throws Exception {
        mockMvc.perform(get("/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Juan"))
                .andExpect(jsonPath("$.correo").value("juan@example.com"));
    }

    @Test // Prueba para actualizar un cliente existente (PUT /clientes/{id})
    public void testObtenerClientePorIdNoExistente() throws Exception {
        mockMvc.perform(get("/clientes/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testActualizarCliente() throws Exception {
        String clienteJson = "{\"nombre\": \"Juanito\", \"correo\": \"juanito@example.com\"}";

        mockMvc.perform(put("/clientes/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(clienteJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Juanito"))
                .andExpect(jsonPath("$.correo").value("juanito@example.com"));
    }

    @Test // Prueba para eliminar un cliente existente (DELETE /clientes/{id})
    public void testEliminarClienteExistente() throws Exception {
        Mockito.doNothing().when(clienteRepository).deleteById(1L);
     // Realiza la petición DELETE y valida el resultado
        mockMvc.perform(delete("/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Cliente eliminado con éxito con id 1"));
    }

    @Test  // Prueba para eliminar un cliente (DELETE /clientes/{id})
    public void testEliminarClienteNoExistente() throws Exception {
        mockMvc.perform(delete("/clientes/{id}", 99)) // Realiza la petición DELETE y valida el resultado
               .andExpect(status().isNotFound())  // Espero un 404
               .andExpect(content().string("Cliente no encontrado con id 99"));
    }
}//cierre de la clase principal
