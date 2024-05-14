package br.com.api.advmanager.dto;

import br.com.api.advmanager.models.MovimentacaoProcessual;
import br.com.api.advmanager.models.Pessoa;
import br.com.api.advmanager.models.Processo;
import br.com.api.advmanager.models.enums.StatusProcesso;

import java.time.LocalDateTime;
import java.util.List;

public record ListagemProcessosDTO(
        Long id,
        String processo,
        Pessoa autor,
        String reu,
        String comarca,
        String estado,
        Long numeroVara,
        String vara,
        String acao,
        List<MovimentacaoProcessual> movimentacaoProcessual,
        String situacaoAtual,
        Double valorCausa,
        StatusProcesso status,
        LocalDateTime dataHoraProtocolo

) {
    public ListagemProcessosDTO(Processo processo){
        this(
                processo.getId(),
                processo.getProcesso(),
                processo.getAutor(),
                processo.getReu(),
                processo.getComarca(),
                processo.getEstado(),
                processo.getNumeroVara(),
                processo.getVara(),
                processo.getAcao(),
                processo.getMovimentacaoProcessual(),
                processo.getSituacalAtual(),
                processo.getValorCausa(),
                processo.getStatus(),
                processo.getDataProtocolo()

        );
    }
}
