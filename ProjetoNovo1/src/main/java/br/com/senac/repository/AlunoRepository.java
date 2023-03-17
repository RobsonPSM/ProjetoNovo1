package br.com.senac.repository;
import br.com.senac.domain.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	
}
