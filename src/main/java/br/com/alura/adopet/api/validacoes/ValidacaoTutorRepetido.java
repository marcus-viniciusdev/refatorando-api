package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.CadastrarTutorDto;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.api.service.ValidacaoExpection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoTutorRepetido implements ValidacaoCadastroTutor {
    @Autowired
    private TutorRepository repository;

    public void validar(CadastrarTutorDto dto) {
        boolean telefoneJaCadastrado = repository.existsByTelefone(dto.telefone());
        boolean emailJaCadastrado = repository.existsByEmail(dto.email());

        if (telefoneJaCadastrado || emailJaCadastrado) {
            throw new ValidacaoExpection("Dados já cadastrados para outro tutor!");
        }
    }
}
