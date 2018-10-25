package br.com.springboot.listavip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.listavip.model.Convidado;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long>{
	List<Convidado> findByNome(String nome);
}
