package br.com.springboot.listavip;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.springboot.listavip.model.Convidado;
import br.com.springboot.listavip.repository.ConvidadoRepository;

@Controller
public class ConvidadoController {
	
	@Autowired
	private ConvidadoRepository repository;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model){
		
		Iterable<Convidado> convidados = repository.findAll();
		
		model.addAttribute("convidados", convidados);
		
		return "listaconvidados";
	}
	
	@RequestMapping(value= "salvar", method = RequestMethod.POST)
	public String salvar(@Valid @ModelAttribute Convidado novoConvidado){

	    repository.save(novoConvidado);

	    return "redirect:listaconvidados";
	}
	
	@RequestMapping(value= "buscaUnica", method = RequestMethod.POST)
	public String listaUM(@RequestParam("id") long id, Model model){
		Convidado convidado = repository.findOne(id);
		model.addAttribute("convidado", convidado);
		
		return "redirect:listaconvidados";
	}
}
