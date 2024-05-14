package br.com.api.advmanager.dto;

import br.com.api.advmanager.models.MovimentacaoProcessual;
import br.com.api.advmanager.models.Pessoa;
import br.com.api.advmanager.models.enums.StatusProcesso;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record ProcessosDTO(
        Long id,
        @NotBlank(message = "É necessário informar o número do processo")
        String processo,
        Pessoa autor,
        String reu,
        String comarca,
        String estado,
        Long numeroVara,
        String vara,
        String acao,
        //MovimentacaoProcessual movimentacaoProcessual,
        String situacaoAtual,
        Double valorCausa,
        StatusProcesso status,
        LocalDateTime dataHoraProtocolo

) {
}
