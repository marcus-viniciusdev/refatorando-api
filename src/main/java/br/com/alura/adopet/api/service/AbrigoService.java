package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastrarAbrigoDto;
import br.com.alura.adopet.api.dto.CadastrarPetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.validacoes.ValidacaoCadastroAbrigo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository repository;

    @Autowired
    private List<ValidacaoCadastroAbrigo> validacoes;

    public void cadastrar(CadastrarAbrigoDto dto) {
        Abrigo abrigo = new Abrigo(dto.nome(), dto.telefone(), dto.email());

        validacoes.forEach(v -> v.validar(dto));

        repository.save(abrigo);
    }

    public Abrigo buscaAbrigo(String idOuNome) {
        try {
            Long id = Long.parseLong(idOuNome);
            return repository.getReferenceById(id);
        } catch (NumberFormatException nfe) {
            return repository.findByNome(idOuNome);
        }
    }

    public void cadastrarPets(Abrigo abrigo, CadastrarPetDto dto) {
        Pet pet = new Pet(dto.tipo(), dto.nome(), dto.raca(), dto.idade(), dto.raca(), dto.peso(), abrigo);
        abrigo.getPets().add(pet);
        repository.save(abrigo);
    }

    public List<Pet> listarPets(Abrigo abrigo) {
        return abrigo.getPets();
    }

}
