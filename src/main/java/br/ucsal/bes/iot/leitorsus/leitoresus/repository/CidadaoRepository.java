package br.ucsal.bes.iot.leitorsus.leitoresus.repository;

import br.ucsal.bes.iot.leitorsus.leitoresus.model.Cidadao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CidadaoRepository extends JpaRepository<Cidadao, Long> {
    List<Cidadao> findByIdentificacao(@Param(value = "identificacao") String identificacao);
}
