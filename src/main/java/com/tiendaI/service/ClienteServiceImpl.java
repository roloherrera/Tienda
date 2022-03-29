
package com.tiendaI.service;

import com.tiendaI.dao.ClienteDao;
import com.tiendaI.dao.CreditoDao;
import com.tiendaI.domain.Cliente;
import com.tiendaI.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    private ClienteDao clienteDao;
    
    @Autowired
    private CreditoDao creditoDao;

    @Override
    @Transactional (readOnly = true) // Para manejar transacciones de lectura
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional // Para manejar transacciones de escritura y lectura
    public void save(Cliente cliente) { 
        Credito credito = cliente.getCredito(); 
        credito = creditoDao.save(credito); 
        
        cliente.setCredito(credito); 
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional (readOnly = true) 
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }
    
}
