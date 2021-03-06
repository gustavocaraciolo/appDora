package com.appdora.service.mapper;

import com.appdora.domain.*;
import com.appdora.service.dto.CategoriaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Categoria and its DTO CategoriaDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CategoriaMapper extends EntityMapper<CategoriaDTO, Categoria> {


    @Mapping(target = "produtos", ignore = true)
    Categoria toEntity(CategoriaDTO categoriaDTO);

    default Categoria fromId(Long id) {
        if (id == null) {
            return null;
        }
        Categoria categoria = new Categoria();
        categoria.setId(id);
        return categoria;
    }
}
