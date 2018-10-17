package br.com.springboot.listavip.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.listavip.model.Convidado;
import br.com.springboot.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository repository;
	
	public List<Convidado> findAll() {
		return repository.findAll();
	}
	
	public Convidado findOne(Long id) {
		return repository.findOne(id);
	}
	
	public Convidado save(Convidado convidado) {
		return repository.saveAndFlush(convidado);
	}
	
	public void delete(Long id) {
		repository.delete(id);
	}

}