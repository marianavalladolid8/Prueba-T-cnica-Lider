package com.tuapp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*; // para simular el repositorio

import com.tuapp.model.Cliente;
import com.tuapp.repository.ClienteRepository;
import com.tuapp.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations; //Inicializa los mocks antes de cada prueba.

import java.util.Optional;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks //Inyecta automáticamente las dependencias simuladas en la instancia del servicio.
    private ClienteService clienteService;

    @BeforeEach //Marca advertencia en JUinit, pero no es error
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGuardarCliente() {
        // Arrange
        Cliente cliente = new Cliente();
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        // Act
        Cliente resultado = clienteService.guardarCliente(cliente);

        // Assert
        assertNotNull(resultado);
        assertEquals(cliente.getNombre(), resultado.getNombre());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void testBuscarClientePorIdExistente() {
        // Arrange
        Long id = 1L;
        Cliente cliente = new Cliente();
        when(clienteRepository.findById(id)).thenReturn(Optional.of(cliente));

        // Act
        Optional<Cliente> resultado = clienteService.obtenerClientePorId(id);

        // Assert
        assertNotNull(resultado);
        assertEquals(cliente.getId(), resultado.get());
        verify(clienteRepository, times(1)).findById(id);
    }

    @Test
    void testBuscarClientePorIdNoExistente() {
        // Arrange
        Long id = 2L;
        when(clienteRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> clienteService.obtenerClientePorId(id));
        assertEquals("Cliente no encontrado", exception.getMessage());
        verify(clienteRepository, times(1)).findById(id);
    }
}//cierre de la clase principal