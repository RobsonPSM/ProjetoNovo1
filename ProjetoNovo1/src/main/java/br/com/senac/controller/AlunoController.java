package br.com.senac.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Aluno;
import br.com.senac.service.AlunoService;

@Controller
@RequestMapping("aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping("/listarAlunos")
	public ModelAndView listaTodosAlunos() {
		ModelAndView mv = new ModelAndView("aluno/paginaListaAlunos");
		mv.addObject("alunos", alunoService.buscarTodosAlunos());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAluno() {
		ModelAndView mv = new ModelAndView("aluno/cadastrarAluno");
		mv.addObject("alunos", new Aluno());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarAluno(Aluno aluno) {
		alunoService.salvar(aluno);
		return listaTodosAlunos();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarAluno(@PathVariable("id") Integer idAluno) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("aluno/alterarAluno");
		mv.addObject("aluno", alunoService.buscarPorId(idAluno));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Aluno alunoAlterado) throws ObjectNotFoundException{
		alunoService.salvarAlteracao(alunoAlterado);
		return listaTodosAlunos();
	}
	
	@PostMapping("/excluir/{id}")
	public ModelAndView excluirALuno(@PathVariable("id") Integer id){
		alunoService.excluir(id);
		return listaTodosAlunos();
	}
}
