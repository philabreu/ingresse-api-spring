package com.ingresse.ingresse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingresse.ingresse.model.Categoria;

@Repository
public interface CategoriaRepositoy extends JpaRepository<Categoria, Long> {

}
