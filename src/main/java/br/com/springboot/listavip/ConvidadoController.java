package br.com.springboot.listavip;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.springboot.defaultEmailSender.defaultEmailSender.EmailService;
import br.com.springboot.listavip.model.Convidado;
import br.com.springboot.listavip.repository.ConvidadoRepository;

@Controller
public class ConvidadoController{
	
	@Autowired
	private ConvidadoRepository repository;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model){
		
		Iterable<Convidado> convidados = repository.findAll();
		model.addAttribute("novoConvidado", new Convidado());
		model.addAttribute("convidados", convidados);
		
		return "listaconvidados";
	}
	
	@RequestMapping(value= "salvar", method = RequestMethod.POST)
	public String salvar(@Valid Convidado novoConvidado, BindingResult bindingResult, Model model){
		
		if (bindingResult.hasErrors()) {
			
			System.out.println("TEVE ERROOOO");
			Iterable<Convidado> convidados = repository.findAll();
			model.addAttribute("convidados", convidados);
			model.addAttribute("novoConvidado", novoConvidado);
			
			return "listaconvidados";
        }
		
	    repository.save(novoConvidado);
	    
	    new EmailService();
		EmailService.sendEmail(novoConvidado.getNome(), novoConvidado.getEmail());
	    
	    return "redirect:listaconvidados";
	}
	
	@RequestMapping("/informaConvidado{id}")
	public String informaConvidado(@RequestParam("id") long id, Model model){
		Convidado convidado = repository.findOne(id);
		model.addAttribute("convidado", convidado);
		
		return "redirect:listaconvidados";
	}
	
	@RequestMapping(value= "/remover{id}", method = RequestMethod.GET)
	public String removeConvidado(@RequestParam(name="id") Long id){
		
		repository.delete(id);
		return "redirect:listaconvidados";
	}

}
