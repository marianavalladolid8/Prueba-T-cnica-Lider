package com.tuapp.repository;

import com.tuapp.model.Cliente;  // Importa la entidad Cliente
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  //  Anotación opcional, pero  recomendable
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    //No see agregan metodos personalizados ya no me dio la vida :(
}//cierre de clase principal
