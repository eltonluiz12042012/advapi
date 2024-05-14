package br.com.api.advmanager.repository;

import br.com.api.advmanager.models.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoRepository  extends JpaRepository<Processo, Long> {

}
