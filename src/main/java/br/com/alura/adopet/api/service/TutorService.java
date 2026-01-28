package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AtualizarTutorDto;
import br.com.alura.adopet.api.dto.CadastrarTutorDto;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.api.validacoes.ValidacaoCadastroTutor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    @Autowired
    private List<ValidacaoCadastroTutor> validacoes;

    public void cadastrar(CadastrarTutorDto dto) {
        Tutor tutor = new Tutor(dto.nome(), dto.telefone(), dto.email());

        validacoes.forEach(v -> v.validar(dto));

        repository.save(tutor);
    }

    public void atualizar(@Valid AtualizarTutorDto dto) {
        Tutor tutor = repository.getReferenceById(dto.id());
        tutor.atualizar(dto);
    }
}
