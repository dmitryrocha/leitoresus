package br.ucsal.bes.iot.leitorsus.leitoresus.repository;

import br.ucsal.bes.iot.leitorsus.leitoresus.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	Funcionario findByUsername(String username);
}
