
package com.tiendaI.dao;

import com.tiendaI.model.Cliente;
import org.springframework.data.repository.CrudRepository;


public interface ClienteDao extends CrudRepository<Cliente,Long>{
    
}
