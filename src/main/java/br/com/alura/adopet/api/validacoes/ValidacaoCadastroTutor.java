package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.CadastrarTutorDto;

public interface ValidacaoCadastroTutor {
    void validar(CadastrarTutorDto dto);
}
