package com.appdora.service;

import com.appdora.domain.User;
import com.appdora.service.dto.ClienteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Service Interface for managing Cliente.
 */
public interface ClienteService {

    /**
     * Save a cliente.
     *
     * @param clienteDTO the entity to save
     * @return the persisted entity
     */
    ClienteDTO save(ClienteDTO clienteDTO);

    User saveUser(ClienteDTO clienteDTO);

    /**
     * Get all the clientes.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ClienteDTO> findAll(Pageable pageable);
    /**
     * Get all the ClienteDTO where Checkout is null.
     *
     * @return the list of entities
     */
    List<ClienteDTO> findAllWhereCheckoutIsNull();

    /**
     * Get the "id" cliente.
     *
     * @param id the id of the entity
     * @return the entity
     */
    ClienteDTO findOne(Long id);

    /**
     * Delete the "id" cliente.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the cliente corresponding to the query.
     *
     * @param query the query of the search
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ClienteDTO> search(String query, Pageable pageable);
}
