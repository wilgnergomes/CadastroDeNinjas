package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public MissoesDTO criarMissoes(MissoesDTO missoes) {
        MissoesModel missoesModel = missoesMapper.map(missoes);
        missoesModel = missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }

    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoesModels = missoesRepository.findAll();
        return missoesModels.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO listarMissoesPorId(Long id) {
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        return missao.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO alterarMissoesPorId(Long id, MissoesDTO missaoAtualizada) {
        if (missoesRepository.existsById(id)) {
            MissoesModel missoesModel = missoesMapper.map(missaoAtualizada);
            missoesModel.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missoesModel);
            return missoesMapper.map(missaoSalva);
        }

        return null;
    }

    public void deletarMissoesPorId(Long id) {
        missoesRepository.deleteById(id);
    }



}
