package com.farmacia.FarmaciaMarcia.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.FarmaciaMarcia.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioModel, Long> {
	
	public Optional <UsuarioModel> findByUsuario (String usuario);

}
