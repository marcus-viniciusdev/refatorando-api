package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.CadastrarAbrigoDto;

public interface ValidacaoCadastroAbrigo {
    void validar(CadastrarAbrigoDto dto);
}
